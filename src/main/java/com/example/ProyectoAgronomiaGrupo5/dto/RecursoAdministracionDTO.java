package com.example.ProyectoAgronomiaGrupo5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecursoAdministracionDTO {

    private Integer idRecursoAdministracion;
    private Integer idRecurso;
    private LocalDate fechaRecepcion;
    private Double cantidadRecibida;
    private String observaciones;
    private Boolean estadoRecursoA;
}