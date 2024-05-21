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
                .codUsuario(mesa.getUsuario().getId())
                .build();
    }

    public static Mesa toEntity(MesaDTO mesaDTO, Usuario usuario, Restaurante restaurante) {
        return Mesa
                .builder()
                .id(mesaDTO.getCodMesa())
                .usuario(usuario)
                .qtdCadeira(mesaDTO.getQtdCadeira())
                .restaurante(restaurante)
                .build();
    }
}
