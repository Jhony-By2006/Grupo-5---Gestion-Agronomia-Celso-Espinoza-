package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.dto.MetodoPagoDTO;
import com.example.ProyectoAgronomiaGrupo5.Models.MetodoPago;
import com.example.ProyectoAgronomiaGrupo5.Service.IMetodoPagoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/MetodoPago")
public class MetodoPagoController {

    private final IMetodoPagoService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<MetodoPagoDTO>> findAll() throws Exception {
        List<MetodoPagoDTO> list = service.findAll()
                .stream()
                .map(e -> modelMapper.map(e, MetodoPagoDTO.class))
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoPagoDTO> findById(@PathVariable Integer id) throws Exception {
        MetodoPago obj = service.findById(id);
        return ResponseEntity.ok(modelMapper.map(obj, MetodoPagoDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody MetodoPagoDTO dto) throws Exception {
        MetodoPago obj = service.save(modelMapper.map(dto, MetodoPago.class));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdMetodoPago())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetodoPagoDTO> update(@PathVariable Integer id, @RequestBody MetodoPagoDTO dto) throws Exception {
        MetodoPago obj = service.update(modelMapper.map(dto, MetodoPago.class), id);
        return ResponseEntity.ok(modelMapper.map(obj, MetodoPagoDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}