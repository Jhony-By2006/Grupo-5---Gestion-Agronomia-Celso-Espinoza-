package com.example.proyecto_agronomia_grupo5.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor


public class Proveedor {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_proveedor;
    private String NombreProveedor;
    private String ApellidoProveedor;

}
