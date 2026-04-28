package com.example.proyecto_agronomia_grupo5.Service.Implementation;

import com.example.proyecto_agronomia_grupo5.Models.Recurso;
import com.example.proyecto_agronomia_grupo5.Repository.IRecursoRepository;
import com.example.proyecto_agronomia_grupo5.Service.IRecursoService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class RecursoService implements IRecursoService {
    private final IRecursoRepository repo;
    @Override
    public Recurso save(Recurso recurso)throws Exception {
        return repo.save(recurso);
    }
    @Override
    public Recurso update(Recurso recurso, Integer id) throws Exception {
        recurso.setId_recurso(id);
        return repo.save(recurso);
    }
    @Override
    public List<Recurso> findAll() throws Exception {
        return repo.findAll();
    }
    @Override
    public Recurso findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Recurso());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
