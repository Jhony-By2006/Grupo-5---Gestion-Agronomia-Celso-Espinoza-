package com.example.proyecto_agronomia_grupo5.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Recursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_recurso;
    private Integer id_proveedor;
    private String Nombre;
    private String Tipo;
    private Double Cantidad;
    private String Unidad_medida;
    private Double Costo_unitario;
    private LocalDate Fecha_ingreso;

}
