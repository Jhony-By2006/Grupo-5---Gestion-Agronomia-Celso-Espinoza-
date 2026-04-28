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
public class RecursoAdministracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idRecursoAdministracion;
    // Relación
    @ManyToOne
    @JoinColumn(name = "id_administracion", referencedColumnName = "idAdministracion", nullable = false)
    private Administracion administracion;

    @ManyToOne // FK
    @JoinColumn(name = "id_recurso", nullable = false, foreignKey= @ForeignKey(name="FK_RECURSO_ADMINISTRACION"))

    private Recurso recurso;
    @Column(nullable = false)
    private LocalDate FechaRecepcion;
    @Column(nullable = false)
    private Double CantidaRecibida;
    @Column(nullable = true, length = 160)
    private String Observaciones;
    @Column(nullable = false)
    private boolean EstadoRecursoA;
}
