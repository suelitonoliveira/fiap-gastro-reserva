package br.com.fiap.gastroreserva.entities;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Builder
@Entity
@Table(name = "tb_mesa")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mesa extends Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USUARIO_COD")
    private Usuario usuario;

    @Column(name = "QTD_CADEIRA", nullable = false)
    private Integer qtdCadeira;

    @ManyToOne
    @JoinColumn(name = "COD_RESTAURANTE", nullable = false)
    private Restaurante restaurante;

}
