package com.example.ProyectoAgronomiaGrupo5.Models;


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
    private Integer idReporte;

    // relación
    @ManyToOne
    @JoinColumn(name = "idAdministracion", referencedColumnName = "idAdministracion", nullable = false)
    private Administracion administracion;
    @Column(nullable = false, length = 150)
    private String Titulo;
    @Column(nullable = true, length = 50)
    private String TipoReporte;
    @Column(nullable = false)
    private LocalDateTime FechaGeneracion;
    @Column(nullable = true, length = 200)
    private String Contenido;
    @Column(nullable = false)
    private boolean EstadoReporte;

}
