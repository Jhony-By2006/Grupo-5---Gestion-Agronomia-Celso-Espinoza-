package com.example.proyecto_agronomia_grupo5.Models;

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
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class Recursos_administracion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false)
    private Integer id_recurso;

    @Column(nullable = false)
    private Integer id_administracion;

    @Column(nullable = false)
    private LocalDate fecha_recepcion;

    @Column(nullable = false)
    private Double cantidad_recibida;

    @Column(nullable = true, length = 160)
    private String observaciones;

}
