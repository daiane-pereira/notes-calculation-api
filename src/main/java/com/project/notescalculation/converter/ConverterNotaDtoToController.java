package com.project.notescalculation.converter;

import com.project.notescalculation.domain.NotaDTO;
import com.project.notescalculation.entity.Nota;

public class ConverterNotaDtoToController {

    public static Nota converter(NotaDTO notaDTO) {
        return Nota.builder()
                .nota(notaDTO.getNota())
                .peso(notaDTO.getPeso())
                .aluno(notaDTO.getAluno())
                .disciplina(notaDTO.getDisciplina())
                .build();
    }
}
