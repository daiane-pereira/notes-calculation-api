package com.project.notescalculation.controller;

import com.project.notescalculation.converter.ConverterNotaDtoToController;
import com.project.notescalculation.domain.MediaFinalDisciplinaDTO;
import com.project.notescalculation.domain.NotaDTO;
import com.project.notescalculation.entity.Nota;
import com.project.notescalculation.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/nota")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @PostMapping(value = "/salvar")
    public ResponseEntity<Nota> salvarNota(@RequestBody @Valid NotaDTO notaDTO) {
        Nota nota = ConverterNotaDtoToController.converter(notaDTO);
        notaService.salvarNota(nota);
        return new ResponseEntity<Nota>(nota, HttpStatus.CREATED);
    }

    @GetMapping(value = "/media/{alunoId}/aluno")
    public ResponseEntity<List<MediaFinalDisciplinaDTO>> listarMediaFinal(@PathVariable("alunoId") Long alunoId) {
        List<MediaFinalDisciplinaDTO> media = notaService.listarMediasAluno(alunoId);
        return new ResponseEntity<List<MediaFinalDisciplinaDTO>>(media, HttpStatus.ACCEPTED);
    }
}
