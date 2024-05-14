package br.com.fiap.gastroreserva.service;

import br.com.fiap.gastroreserva.entities.Restaurante;
import br.com.fiap.gastroreserva.repository.RestauranteRepository;
import org.springframework.stereotype.Service;

@Service
public class RestauranteService {
    private final RestauranteRepository restauranteRepository;

    public RestauranteService(RestauranteRepository restauranteRepository){
        this.restauranteRepository = restauranteRepository;
    }

    public Restaurante salvarRestaurante(Restaurante restaurante){
        return restauranteRepository.save(restaurante);
    }
}
