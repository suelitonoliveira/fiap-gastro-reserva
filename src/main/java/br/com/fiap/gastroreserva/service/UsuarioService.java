package br.com.fiap.gastroreserva.service;

import br.com.fiap.gastroreserva.dto.UsuarioDTO;
import br.com.fiap.gastroreserva.entities.TermoAceite;
import br.com.fiap.gastroreserva.entities.Usuario;
import br.com.fiap.gastroreserva.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.gastroreserva.mapper.UsuarioMapper;
import br.com.fiap.gastroreserva.repository.TermoAceiteRepository;
import br.com.fiap.gastroreserva.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final TermoAceiteRepository termoAceiteRepository;

    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        TermoAceite termoAceite = termoAceiteRepository.findById(usuarioDTO.getCodTermoAceite())
                .orElseThrow(() -> new RecursoNaoEncontradoException(String.format("Termo de aceite com id:%d não encontrado", usuarioDTO.getCodTermoAceite())));
        Usuario entity = UsuarioMapper.toEntity(usuarioDTO, termoAceite);
        Usuario usuarioSalvo = usuarioRepository.save(entity);
        return UsuarioMapper.toDTO(usuarioSalvo);
    }
}
