package com.example.ProyectoAgronomiaGrupo5.Service.Implementation;

import com.example.ProyectoAgronomiaGrupo5.Models.Inventario;
import com.example.ProyectoAgronomiaGrupo5.Repository.IGenericRepository;
import com.example.ProyectoAgronomiaGrupo5.Repository.IInventarioRepository;
import com.example.ProyectoAgronomiaGrupo5.Service.IInventarioService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class InventarioService extends GenericService<Inventario, Integer> implements IInventarioService {

    private final IInventarioRepository repo;

    @Override
    protected IGenericRepository<Inventario, Integer> getRepo() {
        return repo;


    }
}