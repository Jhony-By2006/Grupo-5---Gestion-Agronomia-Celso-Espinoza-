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

    private Integer IdProveedor;

    @Column(nullable = false, length = 100)
    private String NombreProveedor;

    @Column(nullable = false, length = 100)
    private String ApellidoProveedor;

    @Column(nullable = false, length = 20)
    private int Ruc;

    @Column(nullable = false, length = 20)
    private String Direccion;

    @Column(nullable = false, length = 20)
    private int Telefono;

    @Column(nullable = false, length = 20)
    private String Email;

    @Column(nullable = true, length = 20)
    private String Estado;

}
