package com.example.proyecto_agronomia_grupo5.Models;


import jakarta.persistence.Entity;//Hace que la clase se mapee como tabla en BD
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor; //Constructor con todos los parametros
import lombok.Data;//Constructor sin parametros
import lombok.NoArgsConstructor; //getters and setters

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Trabajadores {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_trabajador;
    private Integer id_administracion;
    private String NomTrabajador;
    private String ApeTrabajador;
    private String DNI;
    private String Cargo;
    private String Telefono;
    private String Email;
    private LocalDate Fecha_contrato;
    private String Estado;

}
