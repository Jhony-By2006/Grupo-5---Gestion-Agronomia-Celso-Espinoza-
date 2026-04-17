package com.example.proyecto_agronomia_grupo5.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor; //Constructor con todos los parametros
import lombok.Data;//Constructor sin parametros
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor; //getters and setters

import java.time.LocalDate;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity //Hace que la clase mapee como tabla en BD

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Administracion {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id_administracion;

    @Column(nullable = false, length = 100) //name= "nombreAdmin"
    private String nombreAdmin;

    @Column(nullable = false, length =  160)
    private String descripcion;

    @Column(nullable = false, length = 100)
    private String responsable;

    @Column(nullable = false)
    private LocalDate fecha_registro;

}
