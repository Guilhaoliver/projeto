package com.celulardesktop.projeto.repository;

import com.celulardesktop.projeto.models.Aplicacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AplicacaoRepository extends JpaRepository<Aplicacao,Long> {
    Aplicacao findAplicacaoById(Long id);
}
