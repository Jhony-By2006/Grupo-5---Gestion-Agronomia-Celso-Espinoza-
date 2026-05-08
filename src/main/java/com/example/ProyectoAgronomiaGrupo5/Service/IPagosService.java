package com.example.ProyectoAgronomiaGrupo5.Service;

import com.example.ProyectoAgronomiaGrupo5.Models.Pago;
import java.util.List;

public interface IPagosService {

    Pago save(Pago pago) throws Exception;

    Pago update(Pago pago, Integer id) throws Exception;

    List<Pago> findAll() throws Exception;

    Pago findById(Integer id) throws Exception;

    void delete(Integer id) throws Exception;
}