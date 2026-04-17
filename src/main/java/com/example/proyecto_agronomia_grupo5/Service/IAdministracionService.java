package com.example.proyecto_agronomia_grupo5.Service;

import com.example.proyecto_agronomia_grupo5.Models.Administracion; //Modelos

import java.util.List;

public interface IAdministracionService {
    // 1. Guardar una nueva administración
    Administracion save(Administracion administracion) throws Exception;

    // 2. Actualizar una existente (pasando el objeto y su ID)
    Administracion update(Administracion administracion, Integer id) throws Exception;

    // 3. Listar todos los registros
    List<Administracion> findAll() throws Exception;

    // 4. Buscar una administración específica por su ID
    Administracion findById(Integer id) throws Exception;

    // 5. Eliminar una administración
    void delete(Integer id) throws Exception;

}
