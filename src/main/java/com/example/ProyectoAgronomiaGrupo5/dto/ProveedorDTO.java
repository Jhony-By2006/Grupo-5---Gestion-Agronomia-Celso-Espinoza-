package com.example.ProyectoAgronomiaGrupo5.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorDTO {
    private Integer idProveedor;

    @NotNull
    private String nombreProveedor;

    @NotNull
    private String rucProveedor;

    private String direccionProveedor;
    private String telefonoProveedor;
    private String emailProveedor;

    @NotNull
    private Boolean estadoProveedor;
}