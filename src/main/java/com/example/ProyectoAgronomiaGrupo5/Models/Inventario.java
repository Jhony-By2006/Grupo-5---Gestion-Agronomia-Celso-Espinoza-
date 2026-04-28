package com.example.ProyectoAgronomiaGrupo5.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include

    private Integer idInventario;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = true, length = 160)
    private String descripcion;

    @Column(nullable = false)
    private Double stock_actual;

    @Column(nullable = false)
    private Double stock_minimo;

    @Column(length = 30)
    private String unidad_medida;

    private LocalDateTime fecha_actualizacion;

    @OneToMany(mappedBy = "inventario",cascade = CascadeType.ALL)
    private List<ProductoInicial> productosIniciales;

    @OneToMany(mappedBy = "inventario", cascade = CascadeType.ALL)
    private  List<ProductoFinal>productosFinales;

}
