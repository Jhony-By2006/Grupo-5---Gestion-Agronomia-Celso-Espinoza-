package com.example.ProyectoAgronomiaGrupo5.Service.Implementation;

import com.example.ProyectoAgronomiaGrupo5.Models.Inventario;
import com.example.ProyectoAgronomiaGrupo5.Repository.IInventarioRepository;
import com.example.ProyectoAgronomiaGrupo5.Service.IInventarioService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class InventarioService implements IInventarioService {
    private final IInventarioRepository repo;
    @Override
    public Inventario save(Inventario inventario)throws Exception {
        return repo.save(inventario);
    }
    @Override
    public Inventario update(Inventario inventario, Integer id) throws Exception {
        inventario.setIdInventario(id);
        return repo.save(inventario);
    }
    @Override
    public List<Inventario> findAll() throws Exception {
        return repo.findAll();
    }
    @Override
    public Inventario findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Inventario());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}