package br.com.fiap.gastroreserva.repository;

import br.com.fiap.gastroreserva.entities.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

}
