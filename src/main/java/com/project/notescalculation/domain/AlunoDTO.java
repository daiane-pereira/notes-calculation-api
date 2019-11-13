package com.project.notescalculation.domain;

import com.project.notescalculation.entity.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AlunoDTO {

    @NotBlank
    private String nome;

    @NotNull
    private List<Disciplina> disciplina;
}
