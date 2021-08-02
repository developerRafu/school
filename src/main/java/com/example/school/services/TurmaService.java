package com.example.school.services;

import com.example.school.models.Turma;
import com.example.school.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository repository;

    public Turma findById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new RuntimeException("Erro ao buscar objeto"));
    }

    public List<Turma> findAll() {
        return this.repository.findAll();
    }

    public boolean delete(Long id) {
        Turma obj = this.findById(id);
        this.repository.deleteById(obj.getId());
        return true;
    }

    public Turma update(Turma obj) {
        this.findById(obj.getId());
        return this.repository.save(obj);
    }

    public Turma save(Turma obj) {
        return this.repository.save(obj);
    }
}
