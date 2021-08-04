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
public class SchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolApplication.class, args);
    }

}
