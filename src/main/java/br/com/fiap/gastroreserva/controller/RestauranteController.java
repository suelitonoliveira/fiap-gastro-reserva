package br.com.fiap.gastroreserva.controller;

import br.com.fiap.gastroreserva.dto.RestauranteDTO;
import br.com.fiap.gastroreserva.services.RestauranteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurantes")
@RequiredArgsConstructor
public class RestauranteController {


    private final RestauranteService service;

    @PostMapping
    public ResponseEntity<RestauranteDTO> save(@RequestBody @Valid RestauranteDTO restauranteDTO) {
        RestauranteDTO savedRestauranteDTO = service.save(restauranteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRestauranteDTO);
    }

}