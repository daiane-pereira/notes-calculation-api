package com.project.notescalculation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaFinalService {

    @Autowired
    private NotaService notaService;

    public List<MediaFinalService> media(Long alunoId) {
        return null;
    }
}
