package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.Models.Inventario;
import com.example.ProyectoAgronomiaGrupo5.Service.IInventarioService; //Service
import com.example.ProyectoAgronomiaGrupo5.dto.InventarioDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/Inventario")
@RequiredArgsConstructor

// @CrossOrigin(origins = "*")

public class InventarioController {
    private final IInventarioService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<InventarioDTO>> findAll() throws Exception {
        List<InventarioDTO> list = service.findAll()
                .stream()
                .map(e -> modelMapper.map(e, InventarioDTO.class))
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventarioDTO> findById(@PathVariable Integer id) throws Exception {
        Inventario obj = service.findById(id);
        return ResponseEntity.ok(modelMapper.map(obj, InventarioDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody InventarioDTO dto) throws Exception {
        Inventario obj = service.save(modelMapper.map(dto, Inventario.class));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdInventario())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventarioDTO> update(@PathVariable Integer id, @RequestBody InventarioDTO dto) throws Exception {
        Inventario obj = service.update(modelMapper.map(dto, Inventario.class), id);
        return ResponseEntity.ok(modelMapper.map(obj, InventarioDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    /*
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

     */
}