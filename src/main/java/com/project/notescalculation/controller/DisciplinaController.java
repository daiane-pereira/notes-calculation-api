package com.project.notescalculation.controller;

import com.project.notescalculation.converter.ConverterDisciplinaDtoToEntity;
import com.project.notescalculation.domain.DisciplinaDTO;
import com.project.notescalculation.entity.Disciplina;
import com.project.notescalculation.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<Disciplina> cadastrarDisciplina(@RequestBody @Valid DisciplinaDTO disciplinaDTO) {
        Disciplina disciplina = ConverterDisciplinaDtoToEntity.converter(disciplinaDTO);
        disciplinaService.cadastrarDisciplina(disciplina);
        return new ResponseEntity<Disciplina>(disciplina, HttpStatus.CREATED);
    }
}
