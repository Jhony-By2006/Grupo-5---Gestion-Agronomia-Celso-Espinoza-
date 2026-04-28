package com.example.ProyectoAgronomiaGrupo5.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor; //Constructor con todos los parametros
import lombok.Data;//Constructor sin parametros
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor; //getters and setters

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity //Hace que la clase mapee como tabla en BD

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Administracion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include

    private Integer idAdministracion;
    @Column(nullable = false, length = 100) //name= "nombreAdmin"
    private String Nombre;
    @Column(nullable = false)
    private boolean EstadoAdministracion;
    // RELACIÓN CON REPORTE
    @OneToMany(mappedBy = "administracion", cascade = CascadeType.ALL)
    private List<Reporte> Reportes;
    // RELACIÓN CON RECURSOS
    @OneToMany(mappedBy = "administracion", cascade = CascadeType.ALL)
    private List<RecursoAdministracion> recursosAdministracion;
}
