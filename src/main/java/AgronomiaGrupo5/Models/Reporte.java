package AgronomiaGrupo5.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idReporte;


    // relación

    @ManyToOne
    @JoinColumn(name = "id_administracion", nullable = false)
    private Administracion administracion;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(nullable = true, length = 50)
    private String tipoReporte;

    @Column(nullable = false)
    private LocalDateTime fechaGeneracion;

    @Column(nullable = true, length = 200)
    private String contenido;



}
