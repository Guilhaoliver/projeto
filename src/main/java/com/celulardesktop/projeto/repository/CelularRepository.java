package com.celulardesktop.projeto.repository;

import com.celulardesktop.projeto.models.Celular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CelularRepository extends JpaRepository<Celular,Long> {
    Celular findCelularById(Long id);
}
