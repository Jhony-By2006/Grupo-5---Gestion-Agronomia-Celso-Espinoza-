package com.example.ProyectoAgronomiaGrupo5.Service;

import com.example.ProyectoAgronomiaGrupo5.Models.Recurso;

import java.util.List;

public interface IRecursoService {

    Recurso save(Recurso recurso) throws Exception;

    Recurso update(Recurso recurso, Integer id) throws Exception;

    List<Recurso> findAll() throws Exception;

    Recurso findById(Integer id) throws Exception;

    void delete(Integer id) throws Exception;
}
