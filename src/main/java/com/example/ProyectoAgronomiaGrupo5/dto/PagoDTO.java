package com.example.ProyectoAgronomiaGrupo5.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagoDTO {
    private Integer idPago;

    @NotNull
    private Integer idMetodoPago;

    @NotNull
    private Double monto;

    @NotNull
    private LocalDate fechaPago;

    @NotNull
    private String concepto;

    @NotNull
    private String comprobante;

    @NotNull
    private Boolean estadoPago;
}