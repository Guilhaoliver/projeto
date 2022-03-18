package com.celulardesktop.projeto.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
public class Celular implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String mac;

    @ManyToMany(mappedBy = "celular")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Aplicacao> aplicacoes;
}
