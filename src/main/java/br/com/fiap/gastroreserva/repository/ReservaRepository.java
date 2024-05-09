package br.com.fiap.gastroreserva.repository;

import br.com.fiap.gastroreserva.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
