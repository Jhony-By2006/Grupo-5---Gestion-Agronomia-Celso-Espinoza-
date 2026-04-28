package com.example.ProyectoAgronomiaGrupo5.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> origin/Master

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Recurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
<<<<<<< HEAD
    private Integer id_recurso;

   @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor proveedor;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = true, length = 50)
    private String tipo;

    @Column(nullable = false)
    private Double cantidad;

    @Column(nullable = true, length = 30)
    private String unidad_medida;

    @Column(nullable = true)
    private Double costo_unitario;

    @Column(nullable = true)
    private LocalDate fecha_ingreso;
=======
    private Integer idRecurso;

   @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false, foreignKey= @ForeignKey(name="FK_PROVEEDOR"))
    private Proveedor proveedor;

    @Column(nullable = false, length = 100)
    private String nombreRecurso;
    @Column(nullable = true, length = 50)
    private String tipoRecurso;
    @Column(nullable = false)
    private Double cantidadRecurso;
    @Column(nullable = true, length = 30)
    private String unidadMedidaRecurso;
    @Column(nullable = true)
    private Double costoUnitarioRecurso;
    @Column(nullable = true)
    private LocalDate fechaIngresoRecurso;
    @Column(nullable = false)
    private boolean estadoRecurso;

//    @OneToMany(mappedBy = "recurso", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<RecursoAdministracion> recursosAdministracion;
>>>>>>> origin/Master
}


