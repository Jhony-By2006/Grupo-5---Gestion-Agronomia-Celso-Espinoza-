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
    private Integer idPago;
    @Column(nullable = false)
    private LocalDate fechaPago;
    @Column(nullable = false)
    private Double montoPago;
    @Column(nullable = true, length = 160)
    private String conceptoPago;
    @Column(nullable = true, length = 100)
    private String comprobantePago;
    @Column(nullable = false)
    private boolean estadoPago;

    @ManyToOne
    @JoinColumn(name = "idAdministracion", referencedColumnName = "idAdministracion", nullable = false)
    private Administracion administracion;
    @ManyToOne
    @JoinColumn(name = "idMetodoPago", referencedColumnName = "idMetodoPago", nullable = false)
    private MetodoPago metodoPago;
}
