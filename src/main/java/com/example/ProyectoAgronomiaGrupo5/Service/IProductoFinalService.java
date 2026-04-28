package com.example.ProyectoAgronomiaGrupo5.Service;

import com.example.ProyectoAgronomiaGrupo5.Models.ProductoFinal;
import java.util.List;

public interface IProductoFinalService {

    ProductoFinal save(ProductoFinal productoFinal) throws Exception;

    ProductoFinal update(ProductoFinal productoFinal, Integer id) throws Exception;

    List<ProductoFinal> findAll() throws Exception;

    ProductoFinal findById(Integer id) throws Exception;

    void delete(Integer id) throws Exception;
}
