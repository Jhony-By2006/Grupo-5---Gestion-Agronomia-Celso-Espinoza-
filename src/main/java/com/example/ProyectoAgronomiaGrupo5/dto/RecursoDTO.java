package com.example.ProyectoAgronomiaGrupo5.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecursoDTO {
    private Integer idRecurso;
    private ProveedorDTO proveedor;
    private String nombreRecurso;
    private String tipoRecurso;
    private Double cantidadRecurso;
    private String unidadMedidaRecurso;
    private Double costoRecurso;
    private LocalDate fechaIngresoRecurso;
    private Boolean estadoRecurso;

}