package com.project.notescalculation.controller;

import com.project.notescalculation.converter.ConverterAlunoDtoToEntity;
import com.project.notescalculation.domain.AlunoDTO;
import com.project.notescalculation.entity.Aluno;
import com.project.notescalculation.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<Aluno> cadastrarAluno(@RequestBody @Valid AlunoDTO alunoDTO) {
        Aluno aluno = ConverterAlunoDtoToEntity.converter(alunoDTO);
        alunoService.cadastrarAluno(aluno);
        return new ResponseEntity<Aluno>(aluno, HttpStatus.CREATED);
    }
}
