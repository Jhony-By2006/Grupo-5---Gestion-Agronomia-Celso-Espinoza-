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
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idInventario;

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
    private boolean estadoInven;

    @Column(nullable = false)
    private LocalDateTime fechaActualizacionInven;

    @OneToMany(mappedBy = "inventario", cascade = CascadeType.ALL)
    private List<ProductoInicial> productosIniciales;

    @OneToMany(mappedBy = "inventario", cascade = CascadeType.ALL)
    private List<ProductoFinal> productosFinales;
}