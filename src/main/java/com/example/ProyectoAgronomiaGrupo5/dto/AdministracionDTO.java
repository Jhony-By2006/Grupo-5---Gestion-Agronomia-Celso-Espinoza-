package com.example.ProyectoAgronomiaGrupo5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdministracionDTO {

    private Integer idAdministracion;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaRegistro;
    private String responsable;
    private Boolean estadoAdmin;

    // Relaciones (solo los IDs para no exponer entidades completas)
    private Integer idInventario;
    private Integer idRecursoAdministracion;
    private Integer idReporte;
    private Integer idTrabajador;
    private Integer idMetodoPago;
}