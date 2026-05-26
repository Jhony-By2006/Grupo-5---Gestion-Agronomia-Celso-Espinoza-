package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.dto.ReporteDTO;
import com.example.ProyectoAgronomiaGrupo5.Models.Reporte;
import com.example.ProyectoAgronomiaGrupo5.Service.IReporteService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reportes")
public class ReporteController {

    private final IReporteService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ReporteDTO>> findAll() throws Exception {
        List<ReporteDTO> list = service.findAll().stream()
                .map(e -> modelMapper.map(e, ReporteDTO.class))
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReporteDTO> findById(@PathVariable Integer id) throws Exception {
        Reporte obj = service.findById(id);
        return ResponseEntity.ok(modelMapper.map(obj, ReporteDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ReporteDTO dto) throws Exception {
        Reporte obj = service.save(modelMapper.map(dto, Reporte.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdReporte())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReporteDTO> update(@PathVariable Integer id, @RequestBody ReporteDTO dto) throws Exception {
        Reporte obj = service.update(modelMapper.map(dto, Reporte.class), id);
        return ResponseEntity.ok(modelMapper.map(obj, ReporteDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}