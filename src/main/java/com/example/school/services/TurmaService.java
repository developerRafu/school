package com.example.school.services;

import com.example.school.models.Turma;
import com.example.school.repositories.TurmaRepository;
import com.example.school.services.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository repository;

    public Turma findById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ApiException("Erro ao buscar turma", HttpStatus.NOT_FOUND));
    }

    public List<Turma> findAll() {
        return this.repository.findAll();
    }

    public boolean delete(Long id) {
        Turma obj = this.findById(id);
        try {
            this.repository.deleteById(obj.getId());
            return true;
        } catch (Exception e) {
            throw new ApiException("Erro ao deletar turma", HttpStatus.BAD_REQUEST);
        }
    }

    public Turma update(Turma obj) {
        this.findById(obj.getId());
        try {
            return this.repository.save(obj);
        } catch (Exception e) {
            throw new ApiException("Erro ao atualizar turma", HttpStatus.BAD_REQUEST);
        }
    }

    public Turma save(Turma obj) {
        try {
            return this.repository.save(obj);
        } catch (Exception e) {
            if(e.getMessage().contains("ON PUBLIC.TAB_TURMA(NOME) VALUES")){
                throw new ApiException("Turma já existente", HttpStatus.BAD_REQUEST);
            }
            throw new ApiException("Erro ao salvar turma", HttpStatus.BAD_REQUEST);
        }
    }

    public Page<Turma> findAllPageable(Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        try {
            return this.repository.findAll(pageable);
        } catch (Exception e) {
            throw new ApiException("Erro ao listar turmas", HttpStatus.NOT_FOUND);
        }
    }
}
