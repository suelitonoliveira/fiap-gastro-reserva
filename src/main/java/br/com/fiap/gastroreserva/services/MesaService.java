package br.com.fiap.gastroreserva.services;

import br.com.fiap.gastroreserva.dto.MesaDTO;
import br.com.fiap.gastroreserva.entities.Mesa;
import br.com.fiap.gastroreserva.entities.Restaurante;
import br.com.fiap.gastroreserva.entities.Usuario;
import br.com.fiap.gastroreserva.exceptions.DataIntegrityViolation;
import br.com.fiap.gastroreserva.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.gastroreserva.mapper.MesaMapper;
import br.com.fiap.gastroreserva.repository.MesaRepository;
import br.com.fiap.gastroreserva.repository.RestauranteRepository;
import br.com.fiap.gastroreserva.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import static br.com.fiap.gastroreserva.mapper.MesaMapper.*;

@Service
@RequiredArgsConstructor
public class MesaService {

    private final RestauranteRepository restauranteRepository;

    private final UsuarioRepository usuarioRepository;

    private final MesaRepository mesaRepository;

    public MesaDTO salvarMesa(MesaDTO mesaDTO) {
        try {
            Usuario usuario = usuarioRepository.findById(mesaDTO.getCodUsuario())
                    .orElseThrow(() -> new RecursoNaoEncontradoException(String.format("Usuario com id:%d não encontrado", mesaDTO.getCodUsuario())));

            Restaurante restaurante = restauranteRepository.findById(mesaDTO.getCodRestaurante())
                    .orElseThrow(() -> new RecursoNaoEncontradoException(String.format("Restaurante com id:%d não encontrado", mesaDTO.getCodRestaurante())));

        Mesa entity = MesaMapper.toEntity(mesaDTO,usuario,restaurante);

        Mesa mesaCadastrada = mesaRepository.save(entity);
        return MesaMapper.mesaToMesaDTO(mesaCadastrada);
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolation(String.format("Mesa com  id:%d ja cadastrada", mesaDTO.getCodMesa()), ex);
        }
    }
}