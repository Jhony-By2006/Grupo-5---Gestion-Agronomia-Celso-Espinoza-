package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.Models.Trabajador;
import com.example.ProyectoAgronomiaGrupo5.Service.ITrabajadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Trabajadores")
@RequiredArgsConstructor
public class TrabajadorController {

    private final ITrabajadorService service;

    @GetMapping
    public List<Trabajador> findAll() throws Exception {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Trabajador findById(@PathVariable Integer id) throws Exception {
        return service.findById(id);
    }

    @PostMapping
    public Trabajador save(@RequestBody Trabajador trabajador) throws Exception {
        return service.save(trabajador);
    }

    @PutMapping("/{id}")
    public Trabajador update(@PathVariable Integer id, @RequestBody Trabajador trabajador) throws Exception {
        return service.update(trabajador, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
    }
}