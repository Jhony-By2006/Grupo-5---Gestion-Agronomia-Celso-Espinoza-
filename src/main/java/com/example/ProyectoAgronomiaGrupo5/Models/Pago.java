package com.example.ProyectoAgronomiaGrupo5.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor; //Constructor con todos los parametros
import lombok.Data;//Constructor sin parametros
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor; //getters and setters

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table (name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idPago;

    @ManyToOne
    @JoinColumn(name = "id_metodo_pago", nullable = false)
    private MetodoPago metodoPago;


    @Column(nullable = false)
    private Double monto;

    @Column(nullable = false)
    private LocalDate fechaPago;

    @Column(nullable = true, length = 160)
    private String concepto;

    @Column(nullable = true, length = 100)
    private String comprobante;

    @Column(nullable = false)
    private Boolean estadoPago;

}