package br.com.fiap.gastroreserva.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "tb_restaurante")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurante  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    private Long id;

    @Column(name = "NOME_RESTAURANTE")
    private String nome;

    @OneToMany(mappedBy = "restaurante")
    private List<Mesa> mesas;



}
