package com.project.notescalculation.converter;

import com.project.notescalculation.domain.DisciplinaDTO;
import com.project.notescalculation.entity.Disciplina;

public class ConverterDisciplinaDtoToEntity {

    public static Disciplina converter(DisciplinaDTO disciplinaDTO) {
        return Disciplina.builder()
                .nome(disciplinaDTO.getNome())
                .build();
    }
}
