package br.com.fiap.gastroreserva.dto;


import br.com.fiap.gastroreserva.entities.Mesa;
import br.com.fiap.gastroreserva.entities.Reserva;

import java.util.List;

public record RestauranteDTO(
        Long id,
        String nome,
        List<Mesa>mesa,
        List<Reserva> reserva
) {

}
