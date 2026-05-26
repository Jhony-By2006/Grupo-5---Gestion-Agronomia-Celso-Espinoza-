package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.dto.ProductoFinalDTO;
import com.example.ProyectoAgronomiaGrupo5.Models.ProductoFinal;
import com.example.ProyectoAgronomiaGrupo5.Service.IProductoFinalService;
import com.example.ProyectoAgronomiaGrupo5.dto.ProductoFinalDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ProductosFinales")
public class ProductoFinalController {

    private final IProductoFinalService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<com.example.ProyectoAgronomiaGrupo5.dto.ProductoFinalDTO>> findAll() throws Exception {
        List<ProductoFinalDTO> list = service.findAll()
                .stream()
                .map(e -> modelMapper.map(e, ProductoFinalDTO.class))
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoFinalDTO> findById(@PathVariable Integer id) throws Exception {
        ProductoFinal obj = service.findById(id);
        return ResponseEntity.ok(modelMapper.map(obj, ProductoFinalDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ProductoFinalDTO dto) throws Exception {
        ProductoFinal obj = service.save(modelMapper.map(dto, ProductoFinal.class));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdProductoFinal())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoFinalDTO> update(@PathVariable Integer id, @RequestBody ProductoFinalDTO dto) throws Exception {
        ProductoFinal obj = service.update(modelMapper.map(dto, ProductoFinal.class), id);
        return ResponseEntity.ok(modelMapper.map(obj, ProductoFinalDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}