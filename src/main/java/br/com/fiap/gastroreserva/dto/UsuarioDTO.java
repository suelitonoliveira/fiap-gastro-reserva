package br.com.fiap.gastroreserva.dto;

import br.com.fiap.gastroreserva.enums.TipoUsuario;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDTO {

    private TipoUsuario tipoUsuario;

    private String documento;

    private String nome;

    private String senha;

    private String email;

    private String endereco;

    private Long codTermoAceite;


}
