package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.Models.Recurso;
import com.example.ProyectoAgronomiaGrupo5.Service.IRecursoService; //Service
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Recurso")
@RequiredArgsConstructor


public class RecursoController {
    private final IRecursoService service;

    @GetMapping
    public List<Recurso> findAll() throws  Exception{
        return service.findAll();
    }
    @GetMapping("/{id}")
    public Recurso findById(@PathVariable Integer id) throws Exception {
        return service.findById(id);
    }
    @PostMapping
    public  Recurso save(@RequestBody Recurso recurso) throws Exception{
        return service.save(recurso);
    }
    @PutMapping("/{id}")
    public Recurso update(@PathVariable Integer id, @RequestBody Recurso recurso) throws Exception {
        return service.update(recurso, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
    }
}
