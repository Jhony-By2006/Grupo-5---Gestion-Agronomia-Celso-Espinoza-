package com.example.ProyectoAgronomiaGrupo5.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor; //Constructor con todos los parametros
import lombok.Data;//Constructor sin parametros
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor; //getters and setters

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Trabajador {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idTrabajador;

    @ManyToOne
    @JoinColumn(name = "idAdministracion", nullable = false)
    private Administracion administracion;
    @Column(nullable = false, length = 100)
    private String NombreTrabajador;
    @Column(nullable = false, length = 100)
    private String ApellidosTrabajador;
    @Column(nullable = false, length = 15)
    private String Dni;
    @Column(nullable = true, length = 80)
    private String Cargo;
    @Column(nullable = true, length = 20)
    private String Telefono;
    @Column(nullable = true, length = 100)
    private String Email;
    @Column(nullable = true)
    private LocalDate FechaContratoT;

    @Column(nullable = true)
    private boolean estado;

}
