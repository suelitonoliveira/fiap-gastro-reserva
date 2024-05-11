package br.com.fiap.gastroreserva.mapper;

import br.com.fiap.gastroreserva.dto.UsuarioDTO;
import br.com.fiap.gastroreserva.entities.TermoAceite;
import br.com.fiap.gastroreserva.entities.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioDTO usuarioDTO, TermoAceite termoAceite) {
        return Usuario
                .builder()
                .tipoUsuario(usuarioDTO.getTipoUsuario())
                .documento(usuarioDTO.getDocumento())
                .nome(usuarioDTO.getNome())
                .senha(usuarioDTO.getSenha())
                .email(usuarioDTO.getEmail())
                .endereco(usuarioDTO.getEndereco())
                .termoAceite(termoAceite)
                .build();
    }

    public static UsuarioDTO toDTO(Usuario usuario) {
        return UsuarioDTO
                .builder()
                .tipoUsuario(usuario.getTipoUsuario())
                .documento(usuario.getDocumento())
                .nome(usuario.getNome())
                .senha(usuario.getSenha())
                .email(usuario.getEmail())
                .endereco(usuario.getEndereco())
                .codTermoAceite(usuario.getTermoAceite().getId())
                .build();
    }
}
