package com.example.ProyectoAgronomiaGrupo5.Service.Implementation;

import com.example.ProyectoAgronomiaGrupo5.Models.Reporte;
import com.example.ProyectoAgronomiaGrupo5.Repository.IReporteRepository;
import com.example.ProyectoAgronomiaGrupo5.Service.IReporteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReporteService implements IReporteService {

    private final IReporteRepository repo;

    @Override
    public Reporte save(Reporte reporte) throws Exception {
        return repo.save(reporte);
    }

    @Override
    public Reporte update(Reporte reporte, Integer id) throws Exception {
        reporte.setIdReporte(id);
        return repo.save(reporte);
    }

    @Override
    public List<Reporte> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Reporte findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Reporte());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}