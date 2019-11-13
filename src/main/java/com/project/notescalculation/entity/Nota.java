package com.project.notescalculation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Nota implements Serializable {

    private static final long serialVersionUID = 8590442046444041934L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private BigDecimal nota;

    @NotNull
    private BigDecimal peso;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Disciplina disciplina;
}
