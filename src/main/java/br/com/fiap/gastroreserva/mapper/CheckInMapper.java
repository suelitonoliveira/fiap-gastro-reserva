package br.com.fiap.gastroreserva.mapper;


import br.com.fiap.gastroreserva.dto.CheckInDTO;
import br.com.fiap.gastroreserva.entities.Reserva;
import org.springframework.stereotype.Component;

@Component
public class CheckInMapper {

    public Reserva toEntity(CheckInDTO checkInDTO) {
        Reserva reserva = new Reserva();
        reserva.setId(checkInDTO.getReservaId());
        reserva.setNomeCliente(checkInDTO.getNomeCliente());
        reserva.setNumeroMesa(checkInDTO.getNumeroMesa());
        return reserva;
    }

    public CheckInDTO toDTO(Reserva reserva) {
        CheckInDTO checkInDTO = new CheckInDTO();
        checkInDTO.setReservaId(reserva.getId());
        checkInDTO.setNomeCliente(reserva.getNomeCliente());
        checkInDTO.setNumeroMesa(reserva.getNumeroMesa());
        return checkInDTO;
    }
}
