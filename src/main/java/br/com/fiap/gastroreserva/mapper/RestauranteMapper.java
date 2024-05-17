package br.com.fiap.gastroreserva.mapper;

import br.com.fiap.gastroreserva.dto.RestauranteDTO;
import br.com.fiap.gastroreserva.entities.Restaurante;

public class RestauranteMapper {

    public static RestauranteDTO convertToDTO(Restaurante restaurante) {
        return new RestauranteDTO(
                restaurante.getId(),
                restaurante.getNome(),
                restaurante.getMesa(),
                restaurante.getReserva());

    }

    public static Restaurante toRestaurante(RestauranteDTO restauranteDTO) {
        return new Restaurante(
                restauranteDTO.id(),
                restauranteDTO.nome(),
                restauranteDTO.mesa(),
                restauranteDTO.reserva()
        );
    }

}
