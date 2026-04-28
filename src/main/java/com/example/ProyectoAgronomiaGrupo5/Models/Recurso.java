package com.example.ProyectoAgronomiaGrupo5.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Recurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id_recurso;

   @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor proveedor;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = true, length = 50)
    private String tipo;

    @Column(nullable = false)
    private Double cantidad;

    @Column(nullable = true, length = 30)
    private String unidad_medida;

    @Column(nullable = true)
    private Double costo_unitario;

    @Column(nullable = true)
    private LocalDate fecha_ingreso;
}


