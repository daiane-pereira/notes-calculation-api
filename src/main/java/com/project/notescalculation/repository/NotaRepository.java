package com.project.notescalculation.repository;

import com.project.notescalculation.entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {

    List<Nota> findByDisciplina_Id(Long disciplinaId);
}
