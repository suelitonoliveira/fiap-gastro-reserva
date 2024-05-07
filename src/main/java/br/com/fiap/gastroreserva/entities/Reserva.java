package br.com.fiap.gastroreserva.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tb_reserva")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva extends Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    private Long id;

    @OneToOne(mappedBy = "reserva")
    private Avaliacao avaliacao;

    @OneToOne
    @JoinColumn(name = "USUARIO_COD")
    private Usuario usuario;

    @Column(name = "DESCRICAO")
    private String descricao;

    @ManyToOne
    private Restaurante restaurante;



}
