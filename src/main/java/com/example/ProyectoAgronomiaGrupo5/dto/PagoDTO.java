package com.example.ProyectoAgronomiaGrupo5.dto;

import com.example.ProyectoAgronomiaGrupo5.Models.MetodoPago;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagoDTO {
    private Integer idPago;
    private MetodoPago metodoPago;
    private Double monto;
    private LocalDate fechaPago;
    private String concepto;
    private String comprobante;
    private Boolean estadoPago;
}