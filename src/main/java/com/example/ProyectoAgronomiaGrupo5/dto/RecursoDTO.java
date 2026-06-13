package com.example.ProyectoAgronomiaGrupo5.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecursoDTO {
    private Integer idRecurso;

    @NotNull
    private Integer idProveedor;

    @NotNull
    private String nombreRecurso;

    @NotNull
    private String tipoRecurso;

    @NotNull
    private Double cantidadRecurso;

    @NotNull
    private String unidadMedidaRecurso;

    @NotNull
    private Double costoRecurso;

    @NotNull
    private LocalDate fechaIngresoRecurso;

    @NotNull
    private Boolean estadoRecurso;
}