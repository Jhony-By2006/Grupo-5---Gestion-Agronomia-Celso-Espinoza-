package AgronomiaGrupo5.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor; //Constructor con todos los parametros
import lombok.Data;//Constructor sin parametros
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor; //getters and setters

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Trabajador {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idTrabajador;

    @ManyToOne
    @JoinColumn(name = "id_administracion", nullable = false)
    private Administracion administracion;

    @Column(nullable = false, length = 100)
    private String nomTrabajador;

    @Column(nullable = false, length = 100)
    private String apeTrabajador;

    @Column(nullable = false, length = 15)
    private String dni;

    @Column(nullable = true, length = 80)
    private String cargo;

    @Column(nullable = true, length = 20)
    private String telefono;

    @Column(nullable = true, length = 100)
    private String email;

    @Column(nullable = true)
    private LocalDate fechaCsontrato;

    @Column(nullable = true, length = 20)
    private String estado;

}
