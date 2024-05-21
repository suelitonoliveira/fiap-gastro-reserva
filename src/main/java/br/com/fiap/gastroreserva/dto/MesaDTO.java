package br.com.fiap.gastroreserva.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MesaDTO {

    @NotNull(message = "Campo codRestaurante obrigatório")
    private Long codRestaurante;

    @NotNull(message = "Campo  codUsuario obrigatório")
    private Long codUsuario;

    @NotNull(message = "Campo codMesa obrigatório")
    private Long codMesa;

    @NotNull(message = "Campo qtdCadeira obrigatório")
    private Integer qtdCadeira;
}
