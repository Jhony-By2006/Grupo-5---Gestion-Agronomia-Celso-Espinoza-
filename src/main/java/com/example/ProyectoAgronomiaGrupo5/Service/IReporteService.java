package com.example.ProyectoAgronomiaGrupo5.Service;

import com.example.ProyectoAgronomiaGrupo5.Models.Reporte;
import java.util.List;

public interface IReporteService {
    Reporte save(Reporte reporte) throws Exception;
    Reporte update(Reporte reporte, Integer id) throws Exception;
    List<Reporte> findAll() throws Exception;
    Reporte findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}