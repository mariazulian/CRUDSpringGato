package com.frajola.cadastro_gato.business;

import com.frajola.cadastro_gato.infrastructure.entitys.Gato;
import com.frajola.cadastro_gato.infrastructure.repository.GatoRepository;

public class GatoService {
    private final GatoRepository repository;

    public GatoService(GatoRepository repository) {
        this.repository = repository;
    }

    public void salvarGato(Gato gato){
        repository.saveAndFlush(gato);
    }

    public Gato buscarGatoPorRaca(String raca){
        return repository.findByRaca(raca).orElseThrow(
                () -> new RuntimeException("Raça não encontrada")
        );
    }

    public void deletarGatoPorRaca(String raca){
        repository.deleteByRaca(raca);
    }

    public void atualizarGatoPorId(Integer id, Gato gato){
        Gato gatoEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Gato não encontrado"));
        Gato gatoAtualizado = Gato.builder()
                .idade(gato.getIdade() != null ? gato.getIdade() :
                        gatoEntity.getIdade())
                .raca(gato.getRaca() != null ? gato.getRaca() :
                        gatoEntity.getRaca())
                .pelagem(gato.getPelagem() != null ? gato.getPelagem() :
                        gatoEntity.getPelagem())
                .sexo(gato.getSexo() != null ? gato.getSexo() :
                        gatoEntity.getSexo())
                .id(gatoEntity.getId())
                .build();

        repository.saveAndFlush(gatoAtualizado);
    }
}
