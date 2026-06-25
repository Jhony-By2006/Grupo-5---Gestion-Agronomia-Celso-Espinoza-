package com.example.ProyectoAgronomiaGrupo5.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdministracionDTO {
    private Integer idAdministracion;

    @NotNull
    private String nombre;
    private String descripcion;

    @NotNull
    private LocalDate fechaRegistro;

    @NotNull
    private String responsable;

    @NotNull
    private Boolean estadoAdmin;

    @NotNull
    private Integer idInventario;

    @NotNull
    private Integer idRecursoAdministracion;

    @NotNull
    private Integer idReporte;

    @NotNull
    private Integer idTrabajador;

    @NotNull
    private Integer idMetodoPago;
}