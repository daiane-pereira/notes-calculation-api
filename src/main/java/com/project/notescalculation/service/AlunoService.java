package com.project.notescalculation.service;

import com.project.notescalculation.entity.Aluno;
import com.project.notescalculation.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno cadastrarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Optional<Aluno> listarAluno(Long alunoId) {
        return alunoRepository.findById(alunoId);
    }

}
