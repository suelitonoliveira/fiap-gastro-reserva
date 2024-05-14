package br.com.fiap.gastroreserva.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


<<<<<<< HEAD

=======
>>>>>>> 81feee0aee93e3856acd444e1480544284910201
@Builder(builderMethodName = "restauranteBuilder")

@Entity
@Table(name = "tb_restaurante")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurante  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    private Long id;

    @Column(name = "QTD_CADEIRA")
    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mesa> mesa;

    @Column(name = "COD_RESTAURANTE")
    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reserva;
}
