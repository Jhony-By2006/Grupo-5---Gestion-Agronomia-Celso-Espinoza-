package com.example.ProyectoAgronomiaGrupo5.Service.Implementation;

import com.example.ProyectoAgronomiaGrupo5.Models.Trabajador;
import com.example.ProyectoAgronomiaGrupo5.Repository.ITrabajadorRepository;
import com.example.ProyectoAgronomiaGrupo5.Repository.IGenericRepository;
import com.example.ProyectoAgronomiaGrupo5.Service.ITrabajadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrabajadorService extends GenericService<Trabajador, Integer> implements ITrabajadorService {

    private final ITrabajadorRepository repo;

    @Override
    protected IGenericRepository<Trabajador, Integer> getRepo() {
        return repo;
    }
}