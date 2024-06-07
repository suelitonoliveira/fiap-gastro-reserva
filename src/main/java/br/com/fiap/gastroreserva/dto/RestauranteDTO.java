package br.com.fiap.gastroreserva.dto;


import br.com.fiap.gastroreserva.entities.Mesa;
import br.com.fiap.gastroreserva.entities.Reserva;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestauranteDTO {
    @Schema(hidden = true)
    Long id;
    @NotEmpty(message = "Campo nome obrigatório")
    String nome;

    @NotEmpty(message = "Campo nome endereco")
    String endereco;

    @Schema(hidden = true)
    List<MesaDTO> mesa;

    @Schema(hidden = true)
    List<ReservaDTO> reserva;
}
