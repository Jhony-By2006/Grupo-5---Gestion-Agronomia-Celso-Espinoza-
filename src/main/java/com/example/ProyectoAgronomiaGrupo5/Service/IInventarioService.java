package com.example.ProyectoAgronomiaGrupo5.Service;

import com.example.ProyectoAgronomiaGrupo5.Models.Inventario;

import java.util.List;

public interface IInventarioService {

    Inventario save(Inventario inventario) throws Exception;

    Inventario update(Inventario inventario, Integer id) throws Exception;

    List<Inventario> findAll() throws Exception;

    Inventario findById(Integer id) throws Exception;

    void delete(Integer id) throws Exception;
}
