package br.com.fiap.gastroreserva.entities;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name = "tb_termo_aceite")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TermoAceite extends Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COD_USUARIO", nullable = false)
    private Usuario usuario;

    @Column(name = "ACEITO", nullable = false)
    private Boolean seAceito;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

}
