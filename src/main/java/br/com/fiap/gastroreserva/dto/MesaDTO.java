package br.com.fiap.gastroreserva.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MesaDTO {
    private Long cod;
    private Integer qtdCadeira;
}
