package com.example.ProyectoAgronomiaGrupo5.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor; //Constructor con todos los parametros
import lombok.Data;//Constructor sin parametros
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor; //getters and setters

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "administracion")
public class Administracion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idAdministracion;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = true, length = 200)
    private String descripcion;

    @Column(nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(nullable = false, length = 100)
    private String responsable;

    @Column(nullable = false)
    private boolean estadoAdmin;


    @ManyToOne
    @JoinColumn(name = "id_inventario", nullable = false)
    private Inventario inventario;

    @ManyToOne
    @JoinColumn(name = "id_recurso_administracion", nullable = false)
    private RecursoAdministracion recursoAdministracion;

    @ManyToOne
    @JoinColumn(name = "id_reporte", nullable = false)
    private Reporte reporte;

    @ManyToOne
    @JoinColumn(name = "id_trabajador", nullable = false)
    private Trabajador trabajador;

    @ManyToOne
    @JoinColumn(name = "id_metodo_pago", nullable = false)
    private MetodoPago metodoPago;
}
