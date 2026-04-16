package com.example.proyecto_agronomia_grupo5.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Producto_final {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto_final;

    private Integer id_inventario;

    private String nombre;
    private String descripcion;
    private Double cantidad_producida;
    private String unidad_medida;
    private Double precio_venta;
    private LocalDate fecha_produccion;
    private String estado;

}
