package com.example.proyecto_agronomia_grupo5.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id_reporte;

    @Column(nullable = false)
    private Integer id_administracion;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(nullable = true, length = 50)
    private String tipo_reporte;

    @Column(nullable = false)
    private LocalDateTime fecha_generacion;

    @Column(nullable = true, length = 200)
    private String contenido;



}
