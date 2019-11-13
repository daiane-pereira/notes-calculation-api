package com.project.notescalculation.converter;

import com.project.notescalculation.domain.AlunoDTO;
import com.project.notescalculation.entity.Aluno;

public class ConverterAlunoDtoToEntity {

    public static Aluno converter(AlunoDTO alunoDTO) {
        return Aluno.builder()
                .nome(alunoDTO.getNome())
                .disciplinas(alunoDTO.getDisciplina())
                .build();
    }
}
