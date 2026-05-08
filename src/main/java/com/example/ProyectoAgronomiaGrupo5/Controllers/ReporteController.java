package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.Models.Reporte;
import com.example.ProyectoAgronomiaGrupo5.Service.IReporteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reportes")
@RequiredArgsConstructor
public class ReporteController {

    private final IReporteService service;

    @GetMapping
    public List<Reporte> findAll() throws Exception {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Reporte findById(@PathVariable Integer id) throws Exception {
        return service.findById(id);
    }

    @PostMapping
    public Reporte save(@RequestBody Reporte reporte) throws Exception {
        return service.save(reporte);
    }

    @PutMapping("/{id}")
    public Reporte update(@PathVariable Integer id, @RequestBody Reporte reporte) throws Exception {
        return service.update(reporte, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
    }
}