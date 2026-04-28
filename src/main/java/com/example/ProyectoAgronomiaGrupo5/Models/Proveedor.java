package com.example.ProyectoAgronomiaGrupo5.Models;


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

    private Integer id_proveedor;

    @Column(nullable = false, length = 100)
    private String nombreProveedor;

    @Column(nullable = false, length = 100)
    private String apellidoProveedor;

}
