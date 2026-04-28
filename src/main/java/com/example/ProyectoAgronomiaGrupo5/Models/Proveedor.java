package com.example.proyecto_agronomia_grupo5.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include

    private Integer idProveedor;

    @Column(nullable = false, length = 100)
    private String nombreProveedor;

    @Column(nullable = false, length = 100)
    private String apellidoProveedor;

    @Column(nullable = false, length = 20)
    private String ruc;

    @Column(nullable = false, length = 100)
    private String direccion;

    @Column(nullable = false, length = 20)
    private String telefono;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = true, length = 20)
    private String estado;

}
