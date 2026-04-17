package com.example.proyecto_agronomia_grupo5.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto_final {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id_producto_final;

    @Column(nullable = false)
    private Integer id_inventario;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = true, length = 160)
    private String descripcion;

    @Column(nullable = false)
    private Double cantidad_producida;

    @Column(nullable = true, length = 30)
    private String unidad_medida;

    @Column(nullable = true)
    private Double precio_venta;

    @Column(nullable = true)
    private LocalDate fecha_produccion;

    @Column(nullable = true, length = 20)
    private String estado;

}
