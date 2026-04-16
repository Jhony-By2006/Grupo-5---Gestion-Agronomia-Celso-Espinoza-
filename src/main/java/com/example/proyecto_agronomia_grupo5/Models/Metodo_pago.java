package com.example.proyecto_agronomia_grupo5.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Metodo_pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_metodo_pago;
    private String nombre;
    private String descripcion;
    private String estado;

}
