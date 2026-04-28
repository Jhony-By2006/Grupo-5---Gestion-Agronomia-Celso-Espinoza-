package com.example.ProyectoAgronomiaGrupo5.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
//@Table(name="proveedor")
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
    private String Proveedor;
    @Column(nullable = false, length = 100)
    private String direccionProveedor;
    @Column(nullable = false, length = 20)
    private String telefonoProveedor;
    @Column(nullable = false, length = 100)
    private String emailProveedor;
    @Column(nullable = true)
    private boolean estadoProveedor;

}
