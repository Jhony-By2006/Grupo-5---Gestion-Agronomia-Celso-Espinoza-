package com.example.ProyectoAgronomiaGrupo5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteDTO {

    private Integer idReporte;
    private String titulo;
    private String tipoReporte;
    private LocalDateTime fechaGeneracion;
    private String contenido;
    private String generadoPor;
    private Boolean estadoReporte;
}