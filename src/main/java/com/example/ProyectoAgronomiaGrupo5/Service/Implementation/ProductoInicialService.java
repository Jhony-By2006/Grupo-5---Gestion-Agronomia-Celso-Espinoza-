package com.example.ProyectoAgronomiaGrupo5.Service.Implementation;


import com.example.ProyectoAgronomiaGrupo5.Models.ProductoInicial;
import com.example.ProyectoAgronomiaGrupo5.Repository.IProductoInicialRepository;
import com.example.ProyectoAgronomiaGrupo5.Service.IProductoInicialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoInicialService implements IProductoInicialService {

    private final IProductoInicialRepository repo;

    @Override
    public ProductoInicial save(ProductoInicial productoInicial) throws Exception {
        return repo.save(productoInicial);
    }

    @Override
    public ProductoInicial update(ProductoInicial productoInicial, Integer id) throws Exception {

        productoInicial.setIdProductoInicial(id);
        return repo.save(productoInicial);
    }

    @Override
    public List<ProductoInicial> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public ProductoInicial findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new ProductoInicial());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}