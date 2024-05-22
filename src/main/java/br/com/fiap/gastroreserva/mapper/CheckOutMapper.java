package br.com.fiap.gastroreserva.mapper;

import br.com.fiap.gastroreserva.dto.CheckOutDTO;
import br.com.fiap.gastroreserva.entities.Reserva;
import org.springframework.stereotype.Component;

@Component
public class CheckOutMapper {

    public Reserva toEntity(CheckOutDTO checkOutDTO) {
        Reserva reserva = new Reserva();
        reserva.setId(checkOutDTO.getReservaId());
        reserva.setNomeCliente(checkOutDTO.getNomeCliente());
        reserva.setNumeroMesa(checkOutDTO.getNumeroMesa());
        return reserva;
    }

    public CheckOutDTO toDTO(Reserva reserva) {
        CheckOutDTO checkOutDTO = new CheckOutDTO();
        checkOutDTO.setReservaId(reserva.getId());
        checkOutDTO.setNomeCliente(reserva.getNomeCliente());
        checkOutDTO.setNumeroMesa(reserva.getNumeroMesa());
        return checkOutDTO;
    }
}
