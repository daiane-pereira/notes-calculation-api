package com.project.notescalculation.domain;

import com.project.notescalculation.entity.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MediaFinalDisciplinaDTO {

    private Disciplina disciplina;

    private BigDecimal notaFinal;
}
