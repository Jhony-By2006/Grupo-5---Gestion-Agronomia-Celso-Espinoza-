package com.example.proyecto_agronomia_grupo5.Models;

import com.example.proyecto_agronomia_grupo5.Models.Inventario;

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
public class Producto_inicial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id_producto_inicial;
    //Borramos las dos lineas de cod y las reemplazamos por la relacion de inventirio --> producInicial
    @ManyToOne
    @JoinColumn(name = "id_inventario", nullable = false)
    private Inventario inventario;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = true, length = 160)
    private String descripcion;

    @Column(nullable = false)
    private Double cantidad_inicial;

    @Column(nullable = true, length = 30)
    private String unidad_medida;

    @Column(nullable = true)
    private Double costo_unitario;

    @Column(nullable = true)
    private LocalDate fecha_ingreso;

    @Column(nullable = true, length = 100)
    private String proveedor_origen;
}
