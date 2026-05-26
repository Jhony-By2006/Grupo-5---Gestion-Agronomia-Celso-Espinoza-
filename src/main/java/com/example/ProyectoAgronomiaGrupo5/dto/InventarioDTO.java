package com.example.ProyectoAgronomiaGrupo5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventarioDTO {
    private Integer idInventario;
    private Integer idProductoFinal;
    private Integer idProductoInicial;
    private String nombreInven;
    private String descripcionInven;
    private Double stockActualInven;
    private Double stockMinimoInven;
    private String unidadMedidaInven;
    private LocalDateTime fechaActualizacionInven;
    private Boolean estadoInven;
}