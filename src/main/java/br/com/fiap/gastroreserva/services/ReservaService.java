package br.com.fiap.gastroreserva.services;

import br.com.fiap.gastroreserva.dto.ReservaDTO;
import br.com.fiap.gastroreserva.entities.Reserva;
import br.com.fiap.gastroreserva.entities.Restaurante;
import br.com.fiap.gastroreserva.entities.Usuario;
import br.com.fiap.gastroreserva.exceptions.DataIntegrityViolation;
import br.com.fiap.gastroreserva.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.gastroreserva.mapper.ReservaMapper;
import br.com.fiap.gastroreserva.repository.ReservaRepository;
import br.com.fiap.gastroreserva.repository.RestauranteRepository;
import br.com.fiap.gastroreserva.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;

    private final RestauranteRepository restauranteRepository;

    private final UsuarioRepository usuarioRepository;

    private final AutenticacaoService autenticacaoService;

    private final NotificacaoService notificacaoService;

    @Transactional(rollbackOn = Exception.class)
    public ReservaDTO salvarReserva(@Valid ReservaDTO reservaDTO) throws AccessDeniedException {
        try {
            if (!autenticacaoService.verificarSeUsuarioEstaAutenticado()) {
                throw new AccessDeniedException("Acesso negado. Usuário não esta autenticado");
            }
            Usuario usuario = usuarioRepository.findById(reservaDTO.getCodUsuario())
                    .orElseThrow(() -> new RecursoNaoEncontradoException(String.format("Usuario com id:%d não encontrado", reservaDTO.getCodUsuario())));

            Restaurante restaurante = restauranteRepository.findById(reservaDTO.getCodRestaurante())
                    .orElseThrow(() -> new RecursoNaoEncontradoException(String.format("Restaurante com id:%d não encontrado", reservaDTO.getCodRestaurante())));


            var mensaSelecionada = restaurante.getMesa().stream().filter(mesa -> Objects.equals(mesa.getId(), reservaDTO.getCodMesa())).findFirst();

            Reserva entity = ReservaMapper.toEntity(reservaDTO, usuario, restaurante, mensaSelecionada);

            Reserva reservaSalva = reservaRepository.save(entity);

            notificacaoService.enviarNotificacao(usuario,
                    String.format("%s Sua reserva para o restaurante %s foi efetuada com sucesso", usuario.getNome(), restaurante.getNome()));

            return ReservaMapper.toDTO(reservaSalva);
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolation(String.format("Mesa com  id:%d ja agendada selecione outra", reservaDTO.getCodMesa()), ex);
        }
    }
}
