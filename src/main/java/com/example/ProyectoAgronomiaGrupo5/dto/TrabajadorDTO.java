package com.example.ProyectoAgronomiaGrupo5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrabajadorDTO {

    private Integer idTrabajador;
    private String nombreTrabajador;
    private String apellidosTrabajador;
    private String dni;
    private String cargo;
    private String telefono;
    private String email;
    private LocalDate fechaContratoT;
    private Boolean estado;
}