package com.example.ProyectoAgronomiaGrupo5.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoFinalDTO {
    private Integer idProductoFinal;

    @NotNull
    private String nombreProdF;

    private String descripcionProdF;

    @NotNull
    private Double cantidadProducidaProdF;

    @NotNull
    private String unidadMedidaProdF;

    @NotNull
    private Double precioVentaProdF;

    @NotNull
    private LocalDate fechaProduccionProdF;

    @NotNull
    private Boolean estadoProdF;
}