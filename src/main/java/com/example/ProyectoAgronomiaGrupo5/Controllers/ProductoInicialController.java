package com.example.ProyectoAgronomiaGrupo5.Controllers;


import com.example.ProyectoAgronomiaGrupo5.Models.ProductoInicial;
import com.example.ProyectoAgronomiaGrupo5.Service.IProductoInicialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ProductosIniciales")
@RequiredArgsConstructor

public class ProductoInicialController {
    private final IProductoInicialService service;
    @GetMapping
    public List<ProductoInicial> findAll() throws Exception {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProductoInicial findById(@PathVariable Integer id) throws Exception {
        return service.findById(id);
    }

    @PostMapping
    public ProductoInicial save(@RequestBody ProductoInicial productoInicial) throws Exception {
        return service.save(productoInicial);
    }

    @PutMapping("/{id}")
    public ProductoInicial update(@PathVariable Integer id, @RequestBody ProductoInicial productoInicial) throws Exception {
        return service.update(productoInicial, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
    }




}
