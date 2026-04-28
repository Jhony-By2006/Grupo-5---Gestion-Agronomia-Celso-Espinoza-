package com.example.ProyectoAgronomiaGrupo5.Service.Implementation;

import com.example.ProyectoAgronomiaGrupo5.Models.RecursoAdministracion;
import com.example.ProyectoAgronomiaGrupo5.Repository.IRecursoAdministracionRepository;
import com.example.ProyectoAgronomiaGrupo5.Service.IRecursoAdministracionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class RecursoAdministracionService implements IRecursoAdministracionService {
    private final IRecursoAdministracionRepository repo;
    @Override
    public RecursoAdministracion save(RecursoAdministracion recursoAdministracion)throws Exception {
        return repo.save(recursoAdministracion);
    }
    @Override
    public RecursoAdministracion update(RecursoAdministracion recursoAdministracion, Integer id) throws Exception {
        recursoAdministracion.setIdRecursoAdministracion(id);
        return repo.save(recursoAdministracion);
    }
    @Override
    public List<RecursoAdministracion> findAll() throws Exception {
        return repo.findAll();
    }
    @Override
    public RecursoAdministracion findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new RecursoAdministracion());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
