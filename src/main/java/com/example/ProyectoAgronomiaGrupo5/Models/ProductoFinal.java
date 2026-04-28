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
    //Borramos las dos lineas de cod y las reemplazamos por la relacion de inventirio --> producFinal
    @ManyToOne
    @JoinColumn(name = "idInventario", nullable = false)
    private Inventario inventario;
    @Column(nullable = false, length = 100)
    private String Nombre;
    @Column(nullable = true, length = 160)
    private String Descripcion;
    @Column(nullable = false)
    private Double CantidadProducida;
    @Column(nullable = true, length = 30)
    private String UnidadMedidaF;
    @Column(nullable = true)
    private Double PrecioVenta;
    @Column(nullable = true)
    private LocalDate FechaProduccion;
    @Column(nullable = true)
    private boolean EstadoProductoF;

}
