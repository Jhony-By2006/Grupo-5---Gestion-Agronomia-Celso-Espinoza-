package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.Models.ProductoInicial;
import com.example.ProyectoAgronomiaGrupo5.Service.IProductoInicialService;
import com.example.ProyectoAgronomiaGrupo5.dto.ProductoInicialDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ProductosIniciales")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProductoInicialController {

    private final IProductoInicialService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ProductoInicialDTO>> findAll() throws Exception {
        List<ProductoInicialDTO> list = service.findAll()
                .stream()
                .map(e -> modelMapper.map(e, ProductoInicialDTO.class))
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoInicialDTO> findById(@PathVariable Integer id) throws Exception {
        ProductoInicial obj = service.findById(id);
        return ResponseEntity.ok(modelMapper.map(obj, ProductoInicialDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ProductoInicialDTO dto) throws Exception {
        ProductoInicial obj = service.save(modelMapper.map(dto, ProductoInicial.class));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdProductoInicial())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoInicialDTO> update(@PathVariable Integer id,
                                                     @RequestBody ProductoInicialDTO dto) throws Exception {
        ProductoInicial obj = service.update(modelMapper.map(dto, ProductoInicial.class), id);
        return ResponseEntity.ok(modelMapper.map(obj, ProductoInicialDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

    /*
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

     */


