package com.frajola.cadastro_gato.business;

import com.frajola.cadastro_gato.infrastructure.entitys.Gato;
import com.frajola.cadastro_gato.infrastructure.repository.GatoRepository;

public class GatoService {
    private final GatoRepository repository;

    public GatoService(GatoRepository repository) {
        this.repository = repository;
    }

    public void SalvarGato(Gato gato){
        repository.saveAndFlush(gato);
    }

    public Gato buscarGatoPorRaca(String raca){
        return repository.findByRaca(raca).orElseThrow(
                () -> new RuntimeException("Raça não encontrada")
        );
    }
}
