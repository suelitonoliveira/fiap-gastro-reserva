package br.com.fiap.gastroreserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.fiap.gastroreserva.entities.Mesa;

public interface MesaRepository extends JpaRepository<Mesa, Long> {
}

