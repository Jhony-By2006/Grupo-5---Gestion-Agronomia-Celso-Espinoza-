package com.example.ProyectoAgronomiaGrupo5.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecursoAdministracionDTO {
    private Integer idRecursoAdministracion;

    @NotNull
    private Integer idRecurso;

    @NotNull
    private LocalDate fechaRecepcion;

    @NotNull
    private Double cantidadRecibida;

    private String observaciones;

    @NotNull
    private Boolean estadoRecursoA;
}