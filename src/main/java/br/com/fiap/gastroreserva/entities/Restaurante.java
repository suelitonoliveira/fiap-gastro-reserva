package br.com.fiap.gastroreserva.entities;


import jakarta.persistence.*;
import lombok.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;


@Entity
@Table(name = "tb_restaurante")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Restaurante extends Auditoria   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    private Long id;


    @Column(name = "NOME_RESTAURANTE")
    private String nome;


    @Column(name = "QTD_CADEIRA")
    @OneToMany(mappedBy = "restaurante")
    private List<Mesa> mesa;

    @Column(name = "COD_RESTAURANTE")
    @OneToMany(mappedBy = "restaurante")
    @JsonIgnore
    private List<Reserva> reserva;

}
