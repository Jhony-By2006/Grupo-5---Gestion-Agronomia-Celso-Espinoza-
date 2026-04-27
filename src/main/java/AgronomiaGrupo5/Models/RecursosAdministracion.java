package AgronomiaGrupo5.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class RecursosAdministracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id_recurso;

    // Relación
    @ManyToOne
    @JoinColumn(name = "id_administracion", nullable = false)
    private Administracion administracion;

    @Column(nullable = false)
    private LocalDate fechaRecepcion;

    @Column(nullable = false)
    private Double cantidaRecibida;

    @Column(nullable = true, length = 160)
    private String observaciones;


}
