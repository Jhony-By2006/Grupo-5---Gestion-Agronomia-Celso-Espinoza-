package com.example.proyecto_agronomia_grupo5.Models;

import jakarta.persistence.Entity;//Hace que la clase se mapee como tabla en BD
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor; //Constructor con todos los parametros
import lombok.Data;//Constructor sin parametros
import lombok.NoArgsConstructor; //getters and setters

import java.time.LocalDate;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity

public class Administración {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_administracion;
    private String descipcion;
    private String nombreAdmin;
    private String responsable;
    private LocalDate fecha_registro;


}
