package com.example.ProyectoAgronomiaGrupo5.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoInicialDTO {
    private Integer idProductoInicial;

    @NotNull
    private String nombreProdI;

    private String descripcionProdI;

    @NotNull
    private Double cantidadInicialProdI;

    @NotNull
    private String unidadMedidaProdI;

    @NotNull
    private Double costoUnitarioProdI;

    @NotNull
    private LocalDate fechaIngresoProdI;

    private String proveedorOrigenProdI;

    @NotNull
    private Boolean estadoProdI;
}