package com.example.proyecto_agronomia_grupo5.Service.Implementation;

import com.example.proyecto_agronomia_grupo5.Models.ProductoFinal;
import com.example.proyecto_agronomia_grupo5.Repository.IProductoFinalRepository;
import com.example.proyecto_agronomia_grupo5.Service.IProductoFinalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoFinalService implements IProductoFinalService {

    private final IProductoFinalRepository repo;

    @Override
    public ProductoFinal save(ProductoFinal productoFinal) throws Exception {
        return repo.save(productoFinal);
    }

    @Override
    public ProductoFinal update(ProductoFinal productoFinal, Integer id) throws Exception {
        productoFinal.setId_producto_final(id);
        return repo.save(productoFinal);
    }

    @Override
    public List<ProductoFinal> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public ProductoFinal findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new ProductoFinal());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
