package com.example.ProyectoAgronomiaGrupo5.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventarioDTO {
    private Integer idInventario;

    @NotNull
    private Integer idProductoFinal;

    @NotNull
    private Integer idProductoInicial;

    @NotNull
    private String nombreInven;

    private String descripcionInven;

    @NotNull
    private Double stockActualInven;

    @NotNull
    private Double stockMinimoInven;

    @NotNull
    private String unidadMedidaInven;

    @NotNull
    private LocalDateTime fechaActualizacionInven;

    @NotNull
    private Boolean estadoInven;
}