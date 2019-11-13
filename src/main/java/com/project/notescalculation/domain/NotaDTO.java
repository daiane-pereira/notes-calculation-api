package com.project.notescalculation.domain;

import com.project.notescalculation.entity.Aluno;
import com.project.notescalculation.entity.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NotaDTO {

    @NotNull
    private BigDecimal nota;

    @NotNull
    private BigDecimal peso;

    @NotNull
    private Aluno aluno;

    @NotNull
    private Disciplina disciplina;
}
