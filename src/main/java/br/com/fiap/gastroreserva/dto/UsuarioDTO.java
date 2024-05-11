package br.com.fiap.gastroreserva.dto;

import br.com.fiap.gastroreserva.enums.TipoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDTO {

    @NotNull(message = "Campo tipoUsuario obrigatório")
    private TipoUsuario tipoUsuario;

    @NotBlank(message = "Campo  documento obrigatório")
    private String documento;

    @NotBlank(message = "Campo nome obrigatório")
    private String nome;

    @NotBlank(message = "Campo senha obrigatório")
    private String senha;

    @Email
    @NotBlank(message = "Campo email obrigatório")
    private String email;

    @NotBlank(message = "Campo endereco obrigatório")
    private String endereco;

    @NotNull(message = "Campo codTermoAceite obrigatório")
    private Long codTermoAceite;


}
