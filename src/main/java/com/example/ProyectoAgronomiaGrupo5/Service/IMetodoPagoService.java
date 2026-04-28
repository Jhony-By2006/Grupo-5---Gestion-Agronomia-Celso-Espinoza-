package com.example.proyecto_agronomia_grupo5.Service;

import com.example.proyecto_agronomia_grupo5.Models.MetodoPago;

import java.util.List;

public interface IMetodoPagoService {
    //guardar un nuevo metodo de pago
    MetodoPago save(MetodoPago metodo_pago) throws Exception;

    // 2. Actualizar una existente (pasando el objeto y su ID)
    MetodoPago update(MetodoPago metodo_pago, Integer id) throws Exception;

    // 3. Listar todos los registros
    List<MetodoPago> findAll() throws Exception;

    // 4. Buscar una administración específica por su ID
    MetodoPago findById(Integer id) throws Exception;

    // 5. Eliminar una administración
    void delete(Integer id) throws Exception;
}
