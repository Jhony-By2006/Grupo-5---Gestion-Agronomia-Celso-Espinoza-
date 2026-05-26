package com.example.ProyectoAgronomiaGrupo5.Service.Implementation;

import com.example.ProyectoAgronomiaGrupo5.Models.Pago;
import com.example.ProyectoAgronomiaGrupo5.Repository.IPagosRepository;
import com.example.ProyectoAgronomiaGrupo5.Repository.IGenericRepository;
import com.example.ProyectoAgronomiaGrupo5.Service.IPagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PagosService extends GenericService<Pago, Integer> implements IPagoService {

    private final IPagosRepository repo;

    @Override
    protected IGenericRepository<Pago, Integer> getRepo() {
        return repo;
    }
}