package com.example.ProyectoAgronomiaGrupo5.Service.Implementation;

import com.example.ProyectoAgronomiaGrupo5.Models.ProductoFinal;
import com.example.ProyectoAgronomiaGrupo5.Repository.IGenericRepository;
import com.example.ProyectoAgronomiaGrupo5.Repository.IProductoFinalRepository;
import com.example.ProyectoAgronomiaGrupo5.Service.IProductoFinalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductoFinalService extends GenericService<ProductoFinal, Integer> implements IProductoFinalService {

    private final IProductoFinalRepository repo;

    @Override
    protected IGenericRepository<ProductoFinal, Integer> getRepo() {
        return repo;
    }
}
