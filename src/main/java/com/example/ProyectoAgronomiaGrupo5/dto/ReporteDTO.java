package com.example.ProyectoAgronomiaGrupo5.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteDTO {
    private Integer idReporte;

    @NotNull
    private String titulo;

    @NotNull
    private String tipoReporte;

    @NotNull
    private LocalDate fechaGeneracion;

    private String contenido;

    @NotNull
    private String generadoPor;

    @NotNull
    private Boolean estadoReporte;
}