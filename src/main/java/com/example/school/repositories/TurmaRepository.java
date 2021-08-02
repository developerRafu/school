package com.example.school.repositories;

import com.example.school.models.Aluno;
import com.example.school.models.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
}
