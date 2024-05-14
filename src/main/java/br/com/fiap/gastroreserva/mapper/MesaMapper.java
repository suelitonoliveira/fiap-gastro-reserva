package br.com.fiap.gastroreserva.mapper;

import br.com.fiap.gastroreserva.dto.MesaDTO;
import br.com.fiap.gastroreserva.entities.Mesa;

public class MesaMapper {

    public static MesaDTO mesaToMesaDTO(Mesa mesa) {
        return MesaDTO
                .builder()
                .cod(mesa.getId())
                .qtdCadeira(mesa.getQtdCadeira())
                .build();
    }

    public static Mesa mesaDTOToMesa(MesaDTO mesaDTO) {
        return Mesa
                .builder()
                .id(mesaDTO.getCod())
                .qtdCadeira(mesaDTO.getQtdCadeira())
                .build();
    }
}
