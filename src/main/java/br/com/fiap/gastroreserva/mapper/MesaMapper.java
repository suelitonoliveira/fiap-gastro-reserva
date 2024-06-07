package br.com.fiap.gastroreserva.mapper;

import br.com.fiap.gastroreserva.dto.MesaDTO;
import br.com.fiap.gastroreserva.entities.Mesa;
import br.com.fiap.gastroreserva.entities.Restaurante;
import br.com.fiap.gastroreserva.entities.Usuario;

public class MesaMapper {

    public static MesaDTO mesaToMesaDTO(Mesa mesa) {
        return MesaDTO
                .builder()
                .codMesa(mesa.getId())
                .qtdCadeira(mesa.getQtdCadeira())
                .codRestaurante(mesa.getRestaurante().getId())
                .build();
    }

    public static Mesa toEntity(MesaDTO mesaDTO, Restaurante restaurante) {
        return Mesa
                .builder()
                .id(mesaDTO.getCodMesa())
                .qtdCadeira(mesaDTO.getQtdCadeira())
                .restaurante(restaurante)
                .build();
    }

}
