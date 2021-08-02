package com.example.school.controllers;

import com.example.school.models.Aluno;
import com.example.school.models.Turma;
import com.example.school.models.dto.AlunoDTO;
import com.example.school.models.dto.TurmaDTO;
import com.example.school.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class AlunoRestController {

    @Autowired
    private AlunoService service;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(this.service.findAll().stream().map(this::convertToDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(this.convertToDTO(this.service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody AlunoDTO obj) {
        Aluno aluno = this.conterToEntity(obj);
        return ResponseEntity.ok(this.service.save(aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.delete(id));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody AlunoDTO obj) {
        Aluno aluno = this.conterToEntity(obj);
        return ResponseEntity.ok(this.service.update(aluno));
    }

    public Aluno conterToEntity(AlunoDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setId(dto.getId());
        aluno.setIdade(dto.getIdade());
        aluno.setNome(dto.getNome());
        Turma turma = new Turma();
        turma.setId(dto.getTurmaId());
        aluno.setTurma(turma);
        return aluno;
    }

    public AlunoDTO convertToDTO(Aluno aluno) {
        return new AlunoDTO(aluno);
    }
}
