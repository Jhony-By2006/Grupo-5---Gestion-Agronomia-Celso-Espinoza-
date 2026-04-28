package com.example.ProyectoAgronomiaGrupo5.Service;

import com.example.ProyectoAgronomiaGrupo5.Models.ProductoInicial;
import java.util.List;

public interface IProductoInicialService {
    // 1. Guardar un Producto Inicial
    ProductoInicial save(ProductoInicial productoInicial ) throws Exception ;

    // 2. Actualizar una existente (pasando el objeto y su ID)
    ProductoInicial update(ProductoInicial productoInicial, Integer id) throws Exception;

    // 3. Listar todos los Producto Iniciales
    List<ProductoInicial> findAll() throws Exception;

    // 4. Buscar un Producto Inicial específica por su ID
    ProductoInicial findById(Integer id) throws Exception;

    // 5. Eliminar un Producto Inicial
    void delete(Integer id) throws Exception;
}