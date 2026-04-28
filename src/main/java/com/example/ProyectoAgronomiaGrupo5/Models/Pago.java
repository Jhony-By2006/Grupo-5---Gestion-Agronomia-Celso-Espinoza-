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
public class Pago {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id_pago;

    @ManyToOne
    @JoinColumn(name = "id_administracion", nullable = false)
    private Administracion administracion;

    @ManyToOne
    @JoinColumn(name = "id_metodo_pago", nullable = false)
    private MetodoPago metodoPago;

    @Column(nullable = false)
    private LocalDate fecha_pago;

    @Column(nullable = false)
    private Double monto;

    @Column(nullable = true, length = 160)
    private String concepto;

    @Column(nullable = true, length = 20)
    private String estado_pago;

    @Column(nullable = true, length = 100)
    private String comprobante;

}
