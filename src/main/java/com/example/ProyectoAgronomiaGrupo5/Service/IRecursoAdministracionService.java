package com.example.ProyectoAgronomiaGrupo5.Service;

import com.example.ProyectoAgronomiaGrupo5.Models.RecursoAdministracion;

import java.util.List;

public interface IRecursoAdministracionService {

    RecursoAdministracion save(RecursoAdministracion recursoAdministracion) throws Exception;

    RecursoAdministracion update(RecursoAdministracion recursoAdministracion, Integer id) throws Exception;

    List<RecursoAdministracion> findAll() throws Exception;

    RecursoAdministracion findById(Integer id) throws Exception;

    void delete(Integer id) throws Exception;
}
