package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.Models.Pago;
import com.example.ProyectoAgronomiaGrupo5.Service.IPagosService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PagoController {

    private final IPagosService service;

    @GetMapping
    public List<Pago> findAll() throws Exception {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Pago findById(@PathVariable Integer id) throws Exception {
        return service.findById(id);
    }

    @PostMapping
    public Pago save(@RequestBody Pago pago) throws Exception {
        return service.save(pago);
    }

    @PutMapping("/{id}")
    public Pago update(@PathVariable Integer id, @RequestBody Pago pago) throws Exception {
        return service.update(pago, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
    }
}