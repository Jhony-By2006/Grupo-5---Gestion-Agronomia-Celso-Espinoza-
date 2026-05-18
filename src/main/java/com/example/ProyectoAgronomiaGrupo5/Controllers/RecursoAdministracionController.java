package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.Models.RecursoAdministracion;
import com.example.ProyectoAgronomiaGrupo5.Service.IRecursoAdministracionService; //Service
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/RecusoAdministracion")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class RecursoAdministracionController {
    private final IRecursoAdministracionService service;

    @GetMapping
    public List<RecursoAdministracion> findAll() throws  Exception{
        return service.findAll();
    }
    @GetMapping("/{id}")
    public RecursoAdministracion findById(@PathVariable Integer id) throws Exception {
        return service.findById(id);
    }
    @PostMapping
    public  RecursoAdministracion save(@RequestBody RecursoAdministracion recusoAdministracion) throws Exception{
        return service.save(recusoAdministracion);
    }
    @PutMapping("/{id}")
    public RecursoAdministracion update(@PathVariable Integer id, @RequestBody RecursoAdministracion recusoAdministracion) throws Exception {
        return service.update(recusoAdministracion, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
    }
}