package com.example.ProyectoAgronomiaGrupo5.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "producto_inicial")
public class ProductoInicial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idProductoInicial;

    @Column(nullable = false, length = 100)
    private String nombreProdI;

    @Column(nullable = true, length = 160)
    private String descripcionProdI;

    @Column(nullable = false)
    private Double cantidadInicialProdI;

    @Column(nullable = true, length = 30)
    private String unidadMedidaProdI;

    @Column(nullable = true)
    private Double costoUnitarioProdI;

    @Column(nullable = true)
    private LocalDate fechaIngresoProdI;

    @Column(nullable = true, length = 100)
    private String proveedorOrigenProdI;

    @Column(nullable = false)
    private Boolean estadoProdI;
}