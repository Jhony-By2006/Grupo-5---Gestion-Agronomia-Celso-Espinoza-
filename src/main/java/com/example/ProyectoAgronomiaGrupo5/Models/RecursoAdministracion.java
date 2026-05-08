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
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
@Table(name = "recurso_administracion")
public class RecursoAdministracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idRecursoAdministracion;

    @ManyToOne
    @JoinColumn(name = "id_recurso", nullable = false)
    private Recurso recurso;

    @Column(nullable = false)
    private LocalDate fechaRecepcion;

    @Column(nullable = false)
    private Double cantidadRecibida;

    @Column(nullable = true, length = 160)
    private String observaciones;

    @Column(nullable = false)
    private boolean estadoRecursoA;
}
