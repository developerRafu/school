package com.example.school;

import com.example.school.models.Aluno;
import com.example.school.models.Turma;
import com.example.school.models.enums.Grau;
import com.example.school.services.AlunoService;
import com.example.school.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SchoolApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SchoolApplication.class, args);
    }

    @Autowired
    private TurmaService turmaService;
    @Autowired
    private AlunoService alunoService;

    @Override
    public void run(String... args) throws Exception {
        Turma turma = new Turma();
        turma.setNome("202");
        turma.setGrau(Grau.ENSINO_MEDIO);
        Aluno a1 = new Aluno();
        a1.setNome("Rafu");
        a1.setIdade(21);
        a1.setTurma(turma);
        Aluno a2 = new Aluno();
        a2.setNome("Ryanne");
        a2.setIdade(25);
        a2.setTurma(turma);
        this.turmaService.save(turma);
        this.alunoService.saveAll(Arrays.asList(a1, a2));
    }
}
