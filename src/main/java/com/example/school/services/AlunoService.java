package com.example.school.services;

import com.example.school.models.Aluno;
import com.example.school.models.Turma;
import com.example.school.repositories.AlunoRepository;
import com.example.school.services.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;
    @Autowired
    private TurmaService turmaService;

    public Aluno findById(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new ApiException("Erro ao buscar aluno", HttpStatus.NOT_FOUND));
    }

    public List<Aluno> findAll() {
        return this.repository.findAll();
    }

    public boolean delete(Long id) {
        Aluno obj = this.findById(id);
        try {
            this.repository.deleteById(obj.getId());
            return true;
        } catch (Exception e) {
            throw new ApiException("Erro ao deletar aluno", HttpStatus.BAD_REQUEST);
        }
    }

    public Aluno update(Aluno obj) {
        this.findById(obj.getId());
        try {
            return this.repository.save(obj);
        } catch (Exception e) {
            throw new ApiException("Erro ao atualizar dados do aluno", HttpStatus.BAD_REQUEST);
        }
    }

    public Aluno save(Aluno obj) {
        Turma turmaFound = this.turmaService.findById(obj.getTurma().getId());
        try {
            obj.setTurma(turmaFound);
            return this.repository.save(obj);
        }catch (Exception e){
            throw new ApiException("Erro ao salvar aluno", HttpStatus.BAD_REQUEST);
        }
    }

    public List<Aluno> saveAll(List<Aluno> alunos) {
        return this.repository.saveAll(alunos);
    }

    public Page<Aluno> findPage(Integer page, Long escolaId) {
        Pageable pageable = PageRequest.of(page, 10);
        return this.repository.findAllPage(escolaId, pageable);
    }
}
