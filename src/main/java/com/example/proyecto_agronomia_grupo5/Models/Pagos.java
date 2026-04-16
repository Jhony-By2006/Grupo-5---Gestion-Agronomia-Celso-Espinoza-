package com.example.proyecto_agronomia_grupo5.Models;


import jakarta.persistence.Entity;//Hace que la clase se mapee como tabla en BD
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor; //Constructor con todos los parametros
import lombok.Data;//Constructor sin parametros
import lombok.NoArgsConstructor; //getters and setters

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pagos {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_pago;
    private Integer id_administracion;
    private Integer id_metodo_pago;
    private LocalDate fecha_pago;
    private Double monto;
    private String concepto;
    private String estado_pago;
    private String comprobante;


}
