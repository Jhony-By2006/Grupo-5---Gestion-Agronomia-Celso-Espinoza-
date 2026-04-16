package com.example.proyecto_agronomia_grupo5.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Producto_inicial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id_producto_inicial;
    private Integer id_inventario;
    private String nombre;
    private String descripcion;
    private Double cantidad_inicial;
    private String unidad_medida;
    private Double costo_unitario;
    private LocalDate fecha_ingreso;
    private String proveedor_origen;
}
