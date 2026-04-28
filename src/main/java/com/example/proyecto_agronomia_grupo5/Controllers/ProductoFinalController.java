package com.example.proyecto_agronomia_grupo5.Controllers;

import com.example.proyecto_agronomia_grupo5.Models.ProductoFinal;
import com.example.proyecto_agronomia_grupo5.Service.IProductoFinalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ProductosFinales")
@RequiredArgsConstructor
public class ProductoFinalController {

    private final IProductoFinalService service;

    @GetMapping
    public List<ProductoFinal> findAll() throws Exception {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProductoFinal findById(@PathVariable Integer id) throws Exception {
        return service.findById(id);
    }

    @PostMapping
    public ProductoFinal save(@RequestBody ProductoFinal productoFinal) throws Exception {
        return service.save(productoFinal);
    }

    @PutMapping("/{id}")
    public ProductoFinal update(@PathVariable Integer id, @RequestBody ProductoFinal productoFinal) throws Exception {
        return service.update(productoFinal, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
    }
}
