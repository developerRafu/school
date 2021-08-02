package com.example.school.models.dto;

import com.example.school.models.Aluno;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlunoDTO {
    private Long id;
    private String nome;
    private Integer idade;
    private Long turmaId;

    public AlunoDTO() {

    }

    public AlunoDTO(Aluno obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.idade = obj.getIdade();
        this.turmaId = obj.getTurma().getId();
    }
}
