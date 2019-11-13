package com.project.notescalculation.service;

import com.project.notescalculation.domain.MediaFinalDisciplinaDTO;
import com.project.notescalculation.entity.Aluno;
import com.project.notescalculation.entity.Disciplina;
import com.project.notescalculation.entity.Nota;
import com.project.notescalculation.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private AlunoService alunoService;

    public Nota salvarNota(Nota nota) {
        return notaRepository.save(nota);
    }

    public List<MediaFinalDisciplinaDTO> listarMediasAluno(Long alunoId) {
        Optional<Aluno> dadosAluno = alunoService.listarAluno(alunoId);
        List<MediaFinalDisciplinaDTO> mediasDisciplinas = new ArrayList<>();

        dadosAluno.ifPresent(aluno -> {
            aluno.getDisciplinas().forEach(disciplina -> {
                mediasDisciplinas.add(MediaFinalDisciplinaDTO.builder()
                        .disciplina(disciplina)
                        .notaFinal(calcularMediaDisciplina(disciplina))
                        .build());
            });
        });
        return mediasDisciplinas;
    }

    private BigDecimal calcularMediaDisciplina(Disciplina disciplina) {
        List<Nota> notasDisciplina = notaRepository.findByDisciplina_Id(disciplina.getId());
        BigDecimal somaNotas = notasDisciplina.stream().map(n -> n.getNota().multiply(n.getPeso())).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal somaPesos = notasDisciplina.stream().map(Nota::getPeso).reduce(BigDecimal.ZERO, BigDecimal::add);
        return somaNotas.divide(somaPesos);
    }
}
