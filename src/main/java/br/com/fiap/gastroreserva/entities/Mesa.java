package br.com.fiap.gastroreserva.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Entity
@Table(name = "tb_mesa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mesa  extends Auditoria{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    private Long id;

    @Column(name = "QTD_CADEIRA", nullable = false)
    private Integer qtdCadeira;

    @ManyToOne
    @JoinColumn(name = "COD_RESTAURANTE" , nullable = false)
    private Restaurante restaurante;

}
