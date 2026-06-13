package com.example.ProyectoAgronomiaGrupo5.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetodoPagoDTO {
    private Integer idMetodoPago;

    @NotNull
    private String nombre;

    private String descripcion;

    @NotNull
    private Boolean estadoMetodoPago;
}