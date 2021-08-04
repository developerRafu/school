package com.example.school.models;

import com.example.school.models.enums.Grau;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TAB_TURMA")
public class Turma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true )
    private String nome;
    private Grau grau;

    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos = new ArrayList<>();

}
