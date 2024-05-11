package br.com.fiap.gastroreserva.repository;

import br.com.fiap.gastroreserva.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
