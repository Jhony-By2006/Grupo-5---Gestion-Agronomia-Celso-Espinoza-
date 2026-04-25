package com.example.proyecto_agronomia_grupo5.Service;

import com.example.proyecto_agronomia_grupo5.Models.Metodo_pago;

import java.util.List;

public interface IMetodo_pagoService {
    //guardar un nuevo metodo de pago
    Metodo_pago save(Metodo_pago metodo_pago) throws Exception;

    // 2. Actualizar una existente (pasando el objeto y su ID)
    Metodo_pago update(Metodo_pago metodo_pago, Integer id) throws Exception;

    // 3. Listar todos los registros
    List<Metodo_pago> findAll() throws Exception;

    // 4. Buscar una administración específica por su ID
    Metodo_pago findById(Integer id) throws Exception;

    // 5. Eliminar una administración
    void delete(Integer id) throws Exception;
}