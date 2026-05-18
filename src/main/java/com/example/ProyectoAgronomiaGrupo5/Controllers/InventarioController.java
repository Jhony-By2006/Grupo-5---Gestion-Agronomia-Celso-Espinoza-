package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.Models.Inventario;
import com.example.ProyectoAgronomiaGrupo5.Service.IInventarioService; //Service
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Inventario")
@RequiredArgsConstructor

@CrossOrigin(origins = "*")
public class InventarioController {
    private final IInventarioService service;

    @GetMapping
    public List<Inventario> findAll() throws  Exception{
        return service.findAll();
    }
    @GetMapping("/{id}")
    public Inventario findById(@PathVariable Integer id) throws Exception {
        return service.findById(id);
    }
    @PostMapping
    public  Inventario save(@RequestBody Inventario inventario) throws Exception{
        return service.save(inventario);
    }
    @PutMapping("/{id}")
    public Inventario update(@PathVariable Integer id, @RequestBody Inventario inventario) throws Exception {
        return service.update(inventario, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
    }
}