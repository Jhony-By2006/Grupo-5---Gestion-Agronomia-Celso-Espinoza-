package com.example.ProyectoAgronomiaGrupo5.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.swing.text.StyledEditorKit;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "trabajador")
public class Trabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idTrabajador;

    @Column(nullable = false, length = 100)
    private String nombreTrabajador;

    @Column(nullable = false, length = 100)
    private String apellidosTrabajador;

    @Column(nullable = false, length = 15)
    private String dni;

    @Column(nullable = true, length = 80)
    private String cargo;

    @Column(nullable = true, length = 20)
    private String telefono;

    @Column(nullable = true, length = 100)
    private String email;

    @Column(nullable = true)
    private LocalDate fechaContratoT;

    @Column(nullable = false)
    private Boolean estado;
}