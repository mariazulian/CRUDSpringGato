package com.frajola.cadastro_gato.controller;

import com.frajola.cadastro_gato.business.GatoService;
import com.frajola.cadastro_gato.infrastructure.entitys.Gato;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
