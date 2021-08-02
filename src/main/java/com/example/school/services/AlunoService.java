package com.example.school.services;

import com.example.school.models.Aluno;
import com.example.school.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public Aluno findById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new RuntimeException("Erro ao buscar objeto"));
    }

    public List<Aluno> findAll() {
        return this.repository.findAll();
    }

    public boolean delete(Long id) {
        Aluno obj = this.findById(id);
        this.repository.deleteById(obj.getId());
        return true;
    }

    public Aluno update(Aluno obj) {
        this.findById(obj.getId());
        return this.repository.save(obj);
    }

    public Aluno save(Aluno obj) {
        return this.repository.save(obj);
    }
    public List<Aluno> saveAll(List<Aluno> alunos){
        return this.repository.saveAll(alunos);
    }
}
