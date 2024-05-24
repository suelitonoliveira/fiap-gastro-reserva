package br.com.fiap.gastroreserva.services;

import br.com.fiap.gastroreserva.dto.CheckOutDTO;
import br.com.fiap.gastroreserva.entities.Reserva;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckOutService {

    private final ReservaService reservaService;
    private final NotificacaoService notificacaoService;

    public String realizarCheckOut(CheckOutDTO checkOutDTO) {
        Reserva reserva = reservaService.buscarReservaPorNomeCliente(checkOutDTO.getNomeCliente());
        reserva.setCheckedOut(true);
        reservaService.atualizarReserva(reserva);
        notificacaoService.enviarNotificacao(reserva.getUsuario(), "CheckOut realizado com sucesso!");
        return "CheckOut realizado com sucesso!";
    }
}
