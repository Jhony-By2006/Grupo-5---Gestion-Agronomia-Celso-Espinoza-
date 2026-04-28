package com.example.ProyectoAgronomiaGrupo5.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductoFinal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idProductoFinal;

    @ManyToOne
    @JoinColumn(name = "id_inventario", nullable = false)
    private Inventario inventario;

    @Column(nullable = false, length = 100)
    private String nombreProdF;

    @Column(nullable = true, length = 160)
    private String descripcionProdF;

    @Column(nullable = false)
    private Double cantidadProducidaProdF;

    @Column(nullable = true, length = 30)
    private String unidadMedidaProdF;

    @Column(nullable = true)
    private Double precioVentaProdF;

    @Column(nullable = true)
    private LocalDate fechaProduccionProdF;

    @Column(nullable = true)
    private boolean estadoProdF;
}
