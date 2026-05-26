package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.Models.RecursoAdministracion;
import com.example.ProyectoAgronomiaGrupo5.Service.IRecursoAdministracionService; //Service
import com.example.ProyectoAgronomiaGrupo5.dto.RecursoAdministracionDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/RecusoAdministracion")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class RecursoAdministracionController {
    private final IRecursoAdministracionService service;

    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<RecursoAdministracionDTO>> findAll() throws Exception {
        List<RecursoAdministracionDTO> list = service.findAll()
                .stream()
                .map(e -> modelMapper.map(e, RecursoAdministracionDTO.class))
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecursoAdministracionDTO> findById(@PathVariable Integer id) throws Exception {
        RecursoAdministracion obj = service.findById(id);
        return ResponseEntity.ok(modelMapper.map(obj, RecursoAdministracionDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody RecursoAdministracionDTO dto) throws Exception {
        RecursoAdministracion obj = service.save(modelMapper.map(dto, RecursoAdministracion.class));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdRecursoAdministracion())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecursoAdministracionDTO> update(@PathVariable Integer id,
                                                           @RequestBody RecursoAdministracionDTO dto) throws Exception {
        RecursoAdministracion obj = service.update(modelMapper.map(dto, RecursoAdministracion.class), id);
        return ResponseEntity.ok(modelMapper.map(obj, RecursoAdministracionDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    /*
    @GetMapping
    public List<RecursoAdministracion> findAll() throws  Exception{
        return service.findAll();
    }
    @GetMapping("/{id}")
    public RecursoAdministracion findById(@PathVariable Integer id) throws Exception {
        return service.findById(id);
    }
    @PostMapping
    public  RecursoAdministracion save(@RequestBody RecursoAdministracion recusoAdministracion) throws Exception{
        return service.save(recusoAdministracion);
    }
    @PutMapping("/{id}")
    public RecursoAdministracion update(@PathVariable Integer id, @RequestBody RecursoAdministracion recusoAdministracion) throws Exception {
        return service.update(recusoAdministracion, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
    }

     */
}