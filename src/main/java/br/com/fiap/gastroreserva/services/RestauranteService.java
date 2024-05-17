package br.com.fiap.gastroreserva.services;

import br.com.fiap.gastroreserva.dto.RestauranteDTO;
import br.com.fiap.gastroreserva.entities.Restaurante;
import br.com.fiap.gastroreserva.mapper.RestauranteMapper;
import br.com.fiap.gastroreserva.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

import static br.com.fiap.gastroreserva.mapper.RestauranteMapper.convertToDTO;
import static br.com.fiap.gastroreserva.mapper.RestauranteMapper.toRestaurante;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    public RestauranteService(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public Collection<Restaurante> findAll() {
        var restaurantes = restauranteRepository.findAll();
        return restaurantes;
    }

    public RestauranteDTO save(RestauranteDTO restauranteDTO) {
        Restaurante restaurante = toRestaurante(restauranteDTO);
        restaurante = restauranteRepository.save(restaurante);
        return convertToDTO(restaurante);
    }


    public boolean restauranteJaExiste(String nome) {
        return restauranteRepository.existsByNome(nome);
    }

    public List<RestauranteDTO> buscarRestaurantes() {
        return restauranteRepository.findAll().stream().map(RestauranteMapper::convertToDTO).toList();
    }
}
