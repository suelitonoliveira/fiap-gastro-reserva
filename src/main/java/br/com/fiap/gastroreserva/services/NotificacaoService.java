package br.com.fiap.gastroreserva.services;

import br.com.fiap.gastroreserva.entities.Notificacao;
import br.com.fiap.gastroreserva.entities.Usuario;
import br.com.fiap.gastroreserva.enums.TipoNotificacao;
import br.com.fiap.gastroreserva.repository.NotificacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificacaoService {
    private final NotificacaoRepository notificacaoRepository;
    private final MailSenderService mailSenderService;


    public void enviarNotificacao(Usuario usuario, String mensagem) {
        var notificacao = Notificacao
                .builder()
                .mensagem(mensagem)
                .tipoNotificacao(TipoNotificacao.EMAIL)
                .usuario(usuario)
                .build();
        notificacaoRepository.save(notificacao);
        mailSenderService.sendEmail(usuario.getEmail(), "reserva realizada com sucesso", mensagem);
    }
}
