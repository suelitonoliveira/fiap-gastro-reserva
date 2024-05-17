package br.com.fiap.gastroreserva.repository;

import br.com.fiap.gastroreserva.entities.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {
}

