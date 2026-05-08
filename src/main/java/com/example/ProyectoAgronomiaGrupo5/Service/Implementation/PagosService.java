package com.example.ProyectoAgronomiaGrupo5.Service.Implementation;

import com.example.ProyectoAgronomiaGrupo5.Models.Pago;
import com.example.ProyectoAgronomiaGrupo5.Repository.IPagosRepository;
import com.example.ProyectoAgronomiaGrupo5.Service.IPagosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PagosService implements IPagosService {

    private final IPagosRepository repo;

    @Override
    public Pago save(Pago pago) throws Exception {
        return repo.save(pago);
    }

    @Override
    public Pago update(Pago pago, Integer id) throws Exception {
        pago.setIdPago(id);
        return repo.save(pago);
    }

    @Override
    public List<Pago> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Pago findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Pago());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}