package br.com.fiap.gastroreserva.services;

import br.com.fiap.gastroreserva.dto.CheckInDTO;
import br.com.fiap.gastroreserva.dto.ReservaDTO;
import br.com.fiap.gastroreserva.entities.Reserva;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CheckInService {
    private final ReservaService reservaService;

    public String realizarCheckin(CheckInDTO checkInDTO) {
        Reserva reserva = reservaService.buscarReservaPorNomeCliente(checkInDTO.getNomeCliente());

        if (reserva.isCheckedIn()) {
            throw new RuntimeException("Checkin ja realizado");
        }

        reserva.setCheckedIn(true);
        reservaService.atualizarReserva(reserva);

        return "Checkin realizada com sucesso";
    }

    public List<ReservaDTO> listarCheckins() {
      return  reservaService.buscarCheckins();
    }
}
