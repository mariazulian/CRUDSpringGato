package com.frajola.cadastro_gato.controller;

import com.frajola.cadastro_gato.business.GatoService;
import com.frajola.cadastro_gato.infrastructure.entitys.Gato;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gato")
@RequiredArgsConstructor

public class GatoController {

    private final GatoService gatoService;

    @PostMapping
    public ResponseEntity<Void> salvarGato(@RequestBody Gato gato){
        gatoService.salvarGato(gato);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Gato> buscarGatoPorRaca(@RequestParam String raca){
        return ResponseEntity.ok(gatoService.buscarGatoPorRaca(raca));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarGatoPorRaca(@RequestParam String raca){
        gatoService.deletarGatoPorRaca(raca);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarGatoPorId(@RequestParam Integer id,
                                                   @RequestBody Gato gato){
        gatoService.atualizarGatoPorId(id, gato);
        return ResponseEntity.ok().build();
    }
}
