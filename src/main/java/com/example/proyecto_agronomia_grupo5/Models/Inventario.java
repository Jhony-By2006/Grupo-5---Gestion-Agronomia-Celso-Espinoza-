package com.example.proyecto_agronomia_grupo5.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_inventario;
    private Integer id_administracion;
    private String nombre;
    private String descripcion;
    private Double stock_actual;
    private Double stock_minimo;
    private String unidad_medida;
    private LocalDateTime fecha_actualizacion;


}
