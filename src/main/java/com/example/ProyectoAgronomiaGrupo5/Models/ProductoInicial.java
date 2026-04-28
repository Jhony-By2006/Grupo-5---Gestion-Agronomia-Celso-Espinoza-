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
public class ProductoInicial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer IdProductoInicial;
    //Borramos las dos lineas de cod y las reemplazamos por la relacion de inventirio --> producInicial
    @ManyToOne
    @JoinColumn(name = "IdInventario", nullable = false)
    private Inventario inventario;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = true, length = 160)
    private String descripcion;

    @Column(nullable = false)
    private Double cantidadInicial;

    @Column(nullable = true, length = 30)
    private String unidadMedida;

    @Column(nullable = true)
    private Double costoUnitario;

    @Column(nullable = true)
    private LocalDate fechaIngreso;

    @Column(nullable = true, length = 100)
    private String proveedorOrigen;
}
