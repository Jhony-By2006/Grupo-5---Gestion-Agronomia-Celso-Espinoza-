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
    private Integer idProductoInicial;
    //Borramos las dos lineas de cod y las reemplazamos por la relacion de inventirio --> producInicial
    @ManyToOne
    @JoinColumn(name = "idInventario", nullable = false)
    private Inventario inventario;
    @Column(nullable = false, length = 100)
    private String Nombre;
    @Column(nullable = true, length = 160)
    private String Descripcion;
    @Column(nullable = false)
    private Double CantidadInicial;
    @Column(nullable = true, length = 30)
    private String UnidadMedidaI;
    @Column(nullable = true)
    private Double CostoUnitario;
    @Column(nullable = true)
    private LocalDate FechaIngreso;
    @Column(nullable = true, length = 100)
    private String ProveedorOrigen;
    @Column(nullable = false)
    private boolean EstadoProductoI;
}
