package com.example.ProyectoAgronomiaGrupo5.Service.Implementation;

import com.example.ProyectoAgronomiaGrupo5.Models.MetodoPago;
import com.example.ProyectoAgronomiaGrupo5.Repository.IMetodoPagoRepository;
import com.example.ProyectoAgronomiaGrupo5.Repository.IGenericRepository;
import com.example.ProyectoAgronomiaGrupo5.Service.IMetodoPagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MetodoPagoService extends GenericService<MetodoPago, Integer> implements IMetodoPagoService {

    private final IMetodoPagoRepository repo;

    @Override
    protected IGenericRepository<MetodoPago, Integer> getRepo() {
        return repo;
    }
}