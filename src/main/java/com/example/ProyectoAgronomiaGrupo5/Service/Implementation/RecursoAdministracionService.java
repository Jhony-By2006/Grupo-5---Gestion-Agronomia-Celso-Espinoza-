package com.example.ProyectoAgronomiaGrupo5.Service.Implementation;

import com.example.ProyectoAgronomiaGrupo5.Models.RecursoAdministracion;
import com.example.ProyectoAgronomiaGrupo5.Repository.IGenericRepository;
import com.example.ProyectoAgronomiaGrupo5.Repository.IRecursoAdministracionRepository;
import com.example.ProyectoAgronomiaGrupo5.Service.IRecursoAdministracionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecursoAdministracionService extends GenericService<RecursoAdministracion, Integer>
        implements IRecursoAdministracionService {

    private final IRecursoAdministracionRepository repo;

    @Override
    protected IGenericRepository<RecursoAdministracion, Integer> getRepo() {
        return repo;
    }
}