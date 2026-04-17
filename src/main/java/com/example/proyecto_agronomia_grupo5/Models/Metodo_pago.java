package com.example.proyecto_agronomia_grupo5.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Metodo_pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id_metodo_pago;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = true, length = 160)
    private String descripcion;

    @Column(nullable = false, length = 20)
    private String estado;

}
