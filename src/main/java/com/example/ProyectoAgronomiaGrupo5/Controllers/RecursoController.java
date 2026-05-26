package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.dto.RecursoDTO;
import com.example.ProyectoAgronomiaGrupo5.Models.Recurso;
import com.example.ProyectoAgronomiaGrupo5.Service.IRecursoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Recurso") // Tu ruta original en PascalCase
// @CrossOrigin(origins = "*")
public class RecursoController {

    private final IRecursoService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<RecursoDTO>> findAll() throws Exception {

        List<RecursoDTO> list = service.findAll().stream().map(e -> modelMapper.map(e, RecursoDTO.class)).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecursoDTO> findById(@PathVariable Integer id) throws Exception {
        Recurso obj = service.findById(id);

        return ResponseEntity.ok(modelMapper.map(obj, RecursoDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody RecursoDTO dto) throws Exception {
        Recurso obj = service.save(modelMapper.map(dto, Recurso.class));

        // Construcción de la URL dinámica con el ID del recurso generado
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdRecurso()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecursoDTO> update(@PathVariable Integer id, @RequestBody RecursoDTO dto) throws Exception {
        Recurso obj = service.update(modelMapper.map(dto, Recurso.class), id);

        return ResponseEntity.ok(modelMapper.map(obj, RecursoDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}