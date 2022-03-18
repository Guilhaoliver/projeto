package com.celulardesktop.projeto.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
public class Aplicacao implements Serializable {

    private String nome;
    private double tempo;
    private String icone;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany()
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Celular> celular;

    public Aplicacao() {
        this.nome = nome;
        this.tempo = tempo;
        this.icone = icone;
    }

}
