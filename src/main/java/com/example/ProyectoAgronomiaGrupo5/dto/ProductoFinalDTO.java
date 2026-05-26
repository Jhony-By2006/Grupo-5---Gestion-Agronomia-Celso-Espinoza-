package com.example.ProyectoAgronomiaGrupo5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoFinalDTO {
    private Integer idProductoFinal;
    private String nombreProdF;
    private String descripcionProdF;
    private Double cantidadProducidaProdF;
    private String unidadMedidaProdF;
    private Double precioVentaProdF;
    private LocalDate fechaProduccionProdF;
    private Boolean estadoProdF;
}