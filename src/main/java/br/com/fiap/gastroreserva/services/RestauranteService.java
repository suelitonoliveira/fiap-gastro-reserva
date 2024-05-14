package br.com.fiap.gastroreserva.services;

import br.com.fiap.gastroreserva.dto.MesaDTO;
import br.com.fiap.gastroreserva.dto.RestauranteDTO;
import br.com.fiap.gastroreserva.entities.Mesa;
import br.com.fiap.gastroreserva.entities.Restaurante;
import br.com.fiap.gastroreserva.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    private RestauranteDTO convertToDTO(Restaurante restaurante) {

        return new RestauranteDTO(
                restaurante.getId(),
                restaurante.getNome(),
                restaurante.getMesa(),
                restaurante.getReserva()
        );
    }

    private Restaurante toRestaurante(RestauranteDTO restauranteDTO) {
        return new Restaurante(
                restauranteDTO.id(),
                restauranteDTO.nome(),
                restauranteDTO.mesa(),
                restauranteDTO.reserva()
        );
    }


    public boolean restauranteJaExiste(String nome) {
        return restauranteRepository.existsByNome(nome);
    }

}
