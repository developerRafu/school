package com.example.school.controllers;

import com.example.school.models.Aluno;
import com.example.school.models.Turma;
import com.example.school.models.dto.AlunoDTO;
import com.example.school.models.dto.TurmaDTO;
import com.example.school.models.enums.Grau;
import com.example.school.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/turmas")
public class TurmaRestController {

    @Autowired
    private TurmaService service;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(this.service.findAll().stream().map(this::convertToDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(this.convertToDTO(this.service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody TurmaDTO obj) {
        Turma turma = this.conterToEntity(obj);
        return ResponseEntity.ok(this.service.save(turma));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.delete(id));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody TurmaDTO obj) {
        Turma turma = this.conterToEntity(obj);
        return ResponseEntity.ok(this.service.save(turma));

    }

    public Turma conterToEntity(TurmaDTO dto) {
        Turma turma = new Turma();
        turma.setId(dto.getId());
        turma.setGrau(Grau.toEnum(dto.getGrau()));
        turma.setNome(dto.getNome());
        return turma;
    }

    public TurmaDTO convertToDTO(Turma turma) {
        return new TurmaDTO(turma);
    }
}


