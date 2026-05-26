package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.dto.TrabajadorDTO;
import com.example.ProyectoAgronomiaGrupo5.Models.Trabajador;
import com.example.ProyectoAgronomiaGrupo5.Service.ITrabajadorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Trabajadores")
public class TrabajadorController {

    private final ITrabajadorService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<TrabajadorDTO>> findAll() throws Exception {
        List<TrabajadorDTO> list = service.findAll().stream()
                .map(e -> modelMapper.map(e, TrabajadorDTO.class))
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrabajadorDTO> findById(@PathVariable Integer id) throws Exception {
        Trabajador obj = service.findById(id);
        return ResponseEntity.ok(modelMapper.map(obj, TrabajadorDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody TrabajadorDTO dto) throws Exception {
        Trabajador obj = service.save(modelMapper.map(dto, Trabajador.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdTrabajador())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrabajadorDTO> update(@PathVariable Integer id, @RequestBody TrabajadorDTO dto) throws Exception {
        Trabajador obj = service.update(modelMapper.map(dto, Trabajador.class), id);
        return ResponseEntity.ok(modelMapper.map(obj, TrabajadorDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}