package com.example.ProyectoAgronomiaGrupo5.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrabajadorDTO {
    private Integer idTrabajador;

    @NotNull
    private String nombreTrabajador;

    @NotNull
    private String apellidosTrabajador;

    @NotNull
    private String dni;

    @NotNull
    private String cargo;

    private String telefono;
    private String email;
    private LocalDate fechaContratoT;

    @NotNull
    private Boolean estado;
}