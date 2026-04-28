package com.example.ProyectoAgronomiaGrupo5.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Recurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idRecurso;

   @ManyToOne
    @JoinColumn(name = "idProveedor", referencedColumnName = "idProveedor", nullable = false)
    private Proveedor proveedor;
    @Column(nullable = false, length = 100)
    private String Nombre;
    @Column(nullable = true, length = 50)
    private String Tipo;
    @Column(nullable = false)
    private Double Cantidad;
    @Column(nullable = true, length = 30)
    private String UnidadMedida;
    @Column(nullable = true)
    private Double CostoUnitario;
    @Column(nullable = true)
    private LocalDate FechaIngreso;
    @Column(nullable = false)
    private boolean EstadoRecurso;

    @OneToMany(mappedBy = "Recurso", cascade = CascadeType.ALL)
    private List<RecursoAdministracion> recursosAdministracion;

}


