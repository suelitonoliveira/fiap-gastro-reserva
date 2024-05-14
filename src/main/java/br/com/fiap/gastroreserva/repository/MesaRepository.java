package br.com.fiap.gastroreserva.repository;

import br.com.fiap.gastroreserva.entities.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaRepository extends JpaRepository<Restaurante, Long> {

}
