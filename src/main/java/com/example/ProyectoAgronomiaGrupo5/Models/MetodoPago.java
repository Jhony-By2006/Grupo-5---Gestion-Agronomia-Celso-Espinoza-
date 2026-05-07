package com.example.ProyectoAgronomiaGrupo5.Models;


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
@Table (name = "metodo_pago")
public class MetodoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idMetodoPago;

    @ManyToOne
    @JoinColumn(name = "id_pago", nullable = false)
    private Pago pago;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = true, length = 160)
    private String descripcion;

    @Column(nullable = false)
    private boolean estadoMetodoPago;

}
