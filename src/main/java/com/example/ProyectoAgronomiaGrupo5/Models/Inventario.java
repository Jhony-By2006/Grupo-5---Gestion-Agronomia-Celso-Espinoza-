package com.example.ProyectoAgronomiaGrupo5.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table (name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idInventario;

    @ManyToOne
    @JoinColumn(name = "id_producto_final", nullable = false)
    private ProductoFinal productoFinal;

    @ManyToOne
    @JoinColumn(name = "id_producto_inicial", nullable = false)
    private ProductoInicial productoInicial;

    @Column(nullable = false, length = 100)
    private String nombreInven;

    @Column(nullable = true, length = 160)
    private String descripcionInven;

    @Column(nullable = false)
    private Double stockActualInven;

    @Column(nullable = false)
    private Double stockMinimoInven;

    @Column(length = 30)
    private String unidadMedidaInven;

    @Column(nullable = false)
    private LocalDateTime fechaActualizacionInven;

    @Column(nullable = false)
    private Boolean estadoInven;

}