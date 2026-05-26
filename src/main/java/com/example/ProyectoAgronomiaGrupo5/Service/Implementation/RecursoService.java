package com.example.ProyectoAgronomiaGrupo5.Service.Implementation;

import com.example.ProyectoAgronomiaGrupo5.Models.Recurso;
import com.example.ProyectoAgronomiaGrupo5.Repository.IGenericRepository;
import com.example.ProyectoAgronomiaGrupo5.Repository.IRecursoRepository;
import com.example.ProyectoAgronomiaGrupo5.Service.IRecursoService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class RecursoService extends GenericService<Recurso, Integer> implements IRecursoService {

    private final IRecursoRepository repo;

    @Override
    protected IGenericRepository<Recurso, Integer> getRepo() {
        return repo;
    }
    /*
    @Override
    public Recurso save(Recurso recurso)throws Exception {
        return repo.save(recurso);
    }
    @Override
    public Recurso update(Recurso recurso, Integer id) throws Exception {
        recurso.setIdRecurso(id);
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

     */
}
