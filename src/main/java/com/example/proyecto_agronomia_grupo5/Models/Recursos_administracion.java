package com.example.proyecto_agronomia_grupo5.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import com.example.proyecto_agronomia_grupo5.Models.Administracion;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class Recursos_administracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id_recurso;

    // Relación
    @ManyToOne
    @JoinColumn(name = "id_administracion", nullable = false)
    private Administracion administracion;

    @Column(nullable = false)
    private LocalDate fecha_recepcion;

    @Column(nullable = false)
    private Double cantida_recibida;

    @Column(nullable = true, length = 160)
    private String observaciones;


}
