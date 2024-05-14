package br.com.fiap.gastroreserva.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class RestauranteDTO {
    private Long id;
    private String nome;
    private List<MesaDTO> mesas;
}
