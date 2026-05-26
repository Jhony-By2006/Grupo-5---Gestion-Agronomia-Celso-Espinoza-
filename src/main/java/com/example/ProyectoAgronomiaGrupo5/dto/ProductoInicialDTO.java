package com.example.ProyectoAgronomiaGrupo5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoInicialDTO {

    private Integer idProductoInicial;
    private String nombreProdI;
    private String descripcionProdI;
    private Double cantidadInicialProdI;
    private String unidadMedidaProdI;
    private Double costoUnitarioProdI;
    private LocalDate fechaIngresoProdI;
    private String proveedorOrigenProdI;
    private Boolean estadoProdI;
}