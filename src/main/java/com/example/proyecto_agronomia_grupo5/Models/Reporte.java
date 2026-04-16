package com.example.proyecto_agronomia_grupo5.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity

public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_reporte;
    private Integer id_administración;
    private String Titulo;
    private String Tipo_reporte;
    private LocalDateTime Fecha_generacion;
    private String Contenido;
    // private String generado_por; --- Este me da duda consultar

}
