package com.example.proyecto_agronomia_grupo5.Service.Implementation;

import com.example.proyecto_agronomia_grupo5.Models.Trabajador;
import com.example.proyecto_agronomia_grupo5.Repository.ITrabajadorRepository;
import com.example.proyecto_agronomia_grupo5.Service.ITrabajadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrabajadorService implements ITrabajadorService {

    private final ITrabajadorRepository repo;

    @Override
    public Trabajador save(Trabajador trabajador) throws Exception {
        return repo.save(trabajador);
    }

    @Override
    public Trabajador update(Trabajador trabajador, Integer id) throws Exception {
        trabajador.setIdTrabajador(id);
        return repo.save(trabajador);
    }

    @Override
    public List<Trabajador> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Trabajador findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Trabajador());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
