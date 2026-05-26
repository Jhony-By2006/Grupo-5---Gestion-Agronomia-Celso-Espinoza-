package com.example.ProyectoAgronomiaGrupo5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorDTO {
    private Integer idProveedor;
    private String nombreProveedor;
    private String apellidoProveedor;
    private String rucProveedor;
    private String direccionProveedor;
    private String telefonoProveedor;
    private String emailProveedor;
    private Boolean estadoProveedor;

}