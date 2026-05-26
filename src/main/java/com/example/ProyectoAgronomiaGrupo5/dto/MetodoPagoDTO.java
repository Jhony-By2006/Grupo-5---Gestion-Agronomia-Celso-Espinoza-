package com.example.ProyectoAgronomiaGrupo5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetodoPagoDTO {
    private Integer idMetodoPago;
    private String nombre;
    private String descripcion;
    private Boolean estadoMetodoPago;
}