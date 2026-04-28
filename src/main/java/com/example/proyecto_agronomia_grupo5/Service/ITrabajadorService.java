package com.example.proyecto_agronomia_grupo5.Service;

import com.example.proyecto_agronomia_grupo5.Models.Trabajador;
import java.util.List;

public interface ITrabajadorService {

    Trabajador save(Trabajador trabajador) throws Exception;

    Trabajador update(Trabajador trabajador, Integer id) throws Exception;

    List<Trabajador> findAll() throws Exception;

    Trabajador findById(Integer id) throws Exception;

    void delete(Integer id) throws Exception;
}
