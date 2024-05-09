package br.com.fiap.gastroreserva.entities;

import br.com.fiap.gastroreserva.enums.TipoUsuario;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tb_usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario extends Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    private Long id;

    @Column(name = "TIPO_USUARIO", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    @Column(name = "DOCUMENTO", nullable = false)
    private String documento;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "SENHA", nullable = false)
    private String senha;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "ENDERECO", nullable = false)
    private String endereco;

    @OneToOne(cascade = CascadeType.ALL)
    private TermoAceite termoAceite;
}
