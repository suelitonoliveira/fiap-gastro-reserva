package br.com.fiap.gastroreserva.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CheckOutDTO {

    private Long reservaId;
    private String nomeCliente;
    private int numeroMesa;


    public CheckOutDTO() {}


    public CheckOutDTO(Long reservaId, String nomeCliente, int numeroMesa) {
        this.reservaId = reservaId;
        this.nomeCliente = nomeCliente;
        this.numeroMesa = numeroMesa;
    }
}
