package com.example.ProyectoAgronomiaGrupo5.Service.Implementation;

import com.example.ProyectoAgronomiaGrupo5.Models.ProductoInicial;
import com.example.ProyectoAgronomiaGrupo5.Repository.IGenericRepository;
import com.example.ProyectoAgronomiaGrupo5.Repository.IProductoInicialRepository;
import com.example.ProyectoAgronomiaGrupo5.Service.IProductoInicialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductoInicialService extends GenericService<ProductoInicial, Integer>
        implements IProductoInicialService {

    private final IProductoInicialRepository repo;

    @Override
    protected IGenericRepository<ProductoInicial, Integer> getRepo() {
        return repo;
    }
}