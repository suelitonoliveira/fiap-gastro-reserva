package br.com.fiap.gastroreserva.controller;

import br.com.fiap.gastroreserva.dto.RestauranteDTO;
import br.com.fiap.gastroreserva.entities.Restaurante;
import br.com.fiap.gastroreserva.services.RestauranteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/restaurantes")
@RequiredArgsConstructor
public class RestauranteController {

    @Autowired
    private RestauranteService service;

    @PostMapping
    public ResponseEntity<RestauranteDTO> save(@RequestBody @Valid RestauranteDTO restauranteDTO) {
        RestauranteDTO savedRestauranteDTO = service.save(restauranteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRestauranteDTO);
    }

}