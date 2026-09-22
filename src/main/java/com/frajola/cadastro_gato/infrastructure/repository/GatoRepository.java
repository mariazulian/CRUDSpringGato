package com.frajola.cadastro_gato.infrastructure.repository;

import com.frajola.cadastro_gato.infrastructure.entitys.Gato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GatoRepository extends JpaRepository<Gato, Integer> {

    Optional<Gato> findByRaca(String raca);
}
