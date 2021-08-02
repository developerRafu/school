package com.example.school.models.dto;

import com.example.school.models.Turma;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TurmaDTO {
    private Long id;
    private String nome;
    private Integer grau;

    public TurmaDTO(){

    }

    public TurmaDTO(Turma obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.grau = obj.getGrau().getCod();
    }
}
