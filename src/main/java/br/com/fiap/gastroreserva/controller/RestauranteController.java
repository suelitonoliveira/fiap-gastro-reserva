package br.com.fiap.gastroreserva.controller;

import br.com.fiap.gastroreserva.entities.Restaurante;
import br.com.fiap.gastroreserva.service.MesaService;
import br.com.fiap.gastroreserva.service.RestauranteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurante")
public class RestauranteController {

    private final RestauranteService restauranteService;
    private final MesaService mesaService;

    @Autowired
    public RestauranteController(RestauranteService  restauranteService, MesaService mesaService) {
        this.restauranteService = restauranteService;
        this.mesaService = mesaService;
    }

    @PostMapping
    public ResponseEntity<Restaurante> salvarRestaurante(@RequestBody Restaurante restaurante) {
        Restaurante novoRestaurante = restauranteService.salvarRestaurante(restaurante);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoRestaurante);
    }
}