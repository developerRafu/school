package com.example.school.repositories;

import com.example.school.models.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Query("SELECT a FROM Aluno a WHERE a.turma.id =:escolaId")
    Page<Aluno> findAllPage(@Param("escolaId") Long escolaId, Pageable pageable);
}
