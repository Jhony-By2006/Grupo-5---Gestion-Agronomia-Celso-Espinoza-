package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.dto.RecursoDTO;
import com.example.ProyectoAgronomiaGrupo5.Models.Recurso;
import com.example.ProyectoAgronomiaGrupo5.Service.IRecursoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Recurso")
@CrossOrigin(origins = "*")
public class RecursoController {

    private final IRecursoService service;
    private final ModelMapper modelMapper;
    @PreAuthorize("@authorizeLogic.hasAccess('findAll')")

    @GetMapping
    public ResponseEntity<List<EntityModel<RecursoDTO>>> findAll() throws Exception {
        List<EntityModel<RecursoDTO>> list = service.findAll().stream().map(e -> {
            RecursoDTO dto = modelMapper.map(e, RecursoDTO.class);
            EntityModel<RecursoDTO> resource = EntityModel.of(dto);
            try {
                resource.add(linkTo(methodOn(RecursoController.class).findById(e.getIdRecurso())).withSelfRel());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            return resource;
        }).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<RecursoDTO>> findById(@PathVariable Integer id) throws Exception {
        Recurso obj = service.findById(id);
        RecursoDTO dto = modelMapper.map(obj, RecursoDTO.class);

        EntityModel<RecursoDTO> resource = EntityModel.of(dto);
        resource.add(linkTo(methodOn(RecursoController.class).findById(id)).withSelfRel());
        resource.add(linkTo(methodOn(RecursoController.class).findAll()).withRel("all-recursos"));

        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<EntityModel<RecursoDTO>> save(@RequestBody RecursoDTO dto) throws Exception {
        Recurso obj = service.save(modelMapper.map(dto, Recurso.class));
        RecursoDTO resultDto = modelMapper.map(obj, RecursoDTO.class);

        EntityModel<RecursoDTO> resource = EntityModel.of(resultDto);
        resource.add(linkTo(methodOn(RecursoController.class).findById(obj.getIdRecurso())).withSelfRel());
        resource.add(linkTo(methodOn(RecursoController.class).findAll()).withRel("all-recursos"));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdRecurso()).toUri();

        return ResponseEntity.created(location).body(resource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<RecursoDTO>> update(@PathVariable Integer id, @RequestBody RecursoDTO dto) throws Exception {
        Recurso obj = service.update(modelMapper.map(dto, Recurso.class), id);
        RecursoDTO resultDto = modelMapper.map(obj, RecursoDTO.class);

        EntityModel<RecursoDTO> resource = EntityModel.of(resultDto);
        resource.add(linkTo(methodOn(RecursoController.class).findById(id)).withSelfRel());
        resource.add(linkTo(methodOn(RecursoController.class).findAll()).withRel("all-recursos"));

        return ResponseEntity.ok(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}