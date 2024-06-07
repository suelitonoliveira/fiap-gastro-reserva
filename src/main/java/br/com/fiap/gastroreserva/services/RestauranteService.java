package br.com.fiap.gastroreserva.services;

import br.com.fiap.gastroreserva.dto.RestauranteDTO;
import br.com.fiap.gastroreserva.entities.Restaurante;
import br.com.fiap.gastroreserva.mapper.RestauranteMapper;
import br.com.fiap.gastroreserva.repository.MesaRepository;
import br.com.fiap.gastroreserva.repository.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.fiap.gastroreserva.mapper.RestauranteMapper.convertToDTO;
import static br.com.fiap.gastroreserva.mapper.RestauranteMapper.toRestaurante;

@Service
@RequiredArgsConstructor
public class RestauranteService {

    private final RestauranteRepository restauranteRepository;
    private final MesaRepository mesaRepository;

    public RestauranteDTO save(RestauranteDTO restauranteDTO) {
        Restaurante restaurante = toRestaurante(restauranteDTO);
        restaurante = restauranteRepository.save(restaurante);
        return convertToDTO(restaurante);
    }


    public boolean restauranteJaExiste(String nome) {
        return restauranteRepository.existsByNome(nome);
    }


    public List<RestauranteDTO> buscarRestaurantes() {
        return restauranteRepository.findAll()
                .stream()
                .map(RestauranteMapper::convertToDTO)
                .toList();

    }
}
