    package com.example.ProyectoAgronomiaGrupo5.Service.Implementation;

    import com.example.ProyectoAgronomiaGrupo5.Models.Reporte;
    import com.example.ProyectoAgronomiaGrupo5.Repository.IReporteRepository;
    import com.example.ProyectoAgronomiaGrupo5.Repository.IGenericRepository;
    import com.example.ProyectoAgronomiaGrupo5.Service.IReporteService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.stereotype.Service;

    @Service
    @RequiredArgsConstructor
    public class ReporteService extends GenericService<Reporte, Integer> implements IReporteService {

        private final IReporteRepository repo;

        @Override
        protected IGenericRepository<Reporte, Integer> getRepo() {
            return repo;
        }
    }