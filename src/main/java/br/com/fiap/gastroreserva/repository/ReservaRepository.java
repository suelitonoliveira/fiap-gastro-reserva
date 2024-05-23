package br.com.fiap.gastroreserva.repository;

import br.com.fiap.gastroreserva.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    @Query("select r from Reserva r where r.usuario.nome = ?1")
    Optional<Reserva> findByUsuario_Nome(String nome);

}
