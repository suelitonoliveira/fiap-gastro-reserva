package br.com.fiap.gastroreserva.services;

import br.com.fiap.gastroreserva.dto.UsuarioDTO;
import br.com.fiap.gastroreserva.entities.TermoAceite;
import br.com.fiap.gastroreserva.entities.Usuario;
import br.com.fiap.gastroreserva.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.gastroreserva.mapper.UsuarioMapper;
import br.com.fiap.gastroreserva.repository.TermoAceiteRepository;
import br.com.fiap.gastroreserva.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final TermoAceiteRepository termoAceiteRepository;
    private final AutenticacaoService autenticacaoService;

    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) throws AccessDeniedException {
     if (!autenticacaoService.verificarSeUsuarioEstaAutenticado())  {
         throw new AccessDeniedException("Acesso negado. Usuário não esta autenticado");
     }
        TermoAceite termoAceite = termoAceiteRepository.findById(usuarioDTO.getCodTermoAceite())
                .orElseThrow(() -> new RecursoNaoEncontradoException(String.format("Termo de aceite com id:%d não encontrado", usuarioDTO.getCodTermoAceite())));

        Usuario entity = UsuarioMapper.toEntity(usuarioDTO, termoAceite);

        Usuario usuarioSalvo = usuarioRepository.findOne(Example.of(Usuario.usuarioBuilder().cpf(usuarioDTO.getCpf()).build()))
                .map(usuarioExistente -> UsuarioMapper.toUpdate(usuarioExistente, entity))
                .map(usuarioRepository::save)
                .orElseGet(() -> usuarioRepository.save(entity));

        return UsuarioMapper.toDTO(usuarioSalvo);
    }

    public List<UsuarioDTO> listarUsuarios() {
       return  usuarioRepository.findAll().stream().map(UsuarioMapper::toDTO).toList();
    }
}
