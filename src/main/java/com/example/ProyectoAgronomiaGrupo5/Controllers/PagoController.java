package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.dto.PagoDTO;
import com.example.ProyectoAgronomiaGrupo5.Models.Pago;
import com.example.ProyectoAgronomiaGrupo5.Service.IPagoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pagos")
public class PagoController {

    private final IPagoService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<PagoDTO>> findAll() throws Exception {
        List<PagoDTO> list = service.findAll()
                .stream()
                .map(e -> modelMapper.map(e, PagoDTO.class))
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoDTO> findById(@PathVariable Integer id) throws Exception {
        Pago obj = service.findById(id);
        return ResponseEntity.ok(modelMapper.map(obj, PagoDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody PagoDTO dto) throws Exception {
        Pago obj = service.save(modelMapper.map(dto, Pago.class));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdPago())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagoDTO> update(@PathVariable Integer id, @RequestBody PagoDTO dto) throws Exception {
        Pago obj = service.update(modelMapper.map(dto, Pago.class), id);
        return ResponseEntity.ok(modelMapper.map(obj, PagoDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}