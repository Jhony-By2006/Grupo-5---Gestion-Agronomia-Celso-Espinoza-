package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.Models.RecursoAdministracion;
import com.example.ProyectoAgronomiaGrupo5.Service.IRecursoAdministracionService;
import com.example.ProyectoAgronomiaGrupo5.dto.RecursoAdministracionDTO;
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
@RequestMapping("/RecusoAdministracion")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RecursoAdministracionController {

    private final IRecursoAdministracionService service;
    private final ModelMapper modelMapper;
    @PreAuthorize("hasRole('ADMIN')")

    @GetMapping
    public ResponseEntity<List<EntityModel<RecursoAdministracionDTO>>> findAll() throws Exception {
        List<EntityModel<RecursoAdministracionDTO>> list = service.findAll()
                .stream()
                .map(e -> {
                    RecursoAdministracionDTO dto = modelMapper.map(e, RecursoAdministracionDTO.class);
                    EntityModel<RecursoAdministracionDTO> resource = EntityModel.of(dto);
                    try {
                        resource.add(linkTo(methodOn(RecursoAdministracionController.class).findById(e.getIdRecursoAdministracion())).withSelfRel());
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    return resource;
                })
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<RecursoAdministracionDTO>> findById(@PathVariable Integer id) throws Exception {
        RecursoAdministracion obj = service.findById(id);
        RecursoAdministracionDTO dto = modelMapper.map(obj, RecursoAdministracionDTO.class);

        EntityModel<RecursoAdministracionDTO> resource = EntityModel.of(dto);
        resource.add(linkTo(methodOn(RecursoAdministracionController.class).findById(id)).withSelfRel());
        resource.add(linkTo(methodOn(RecursoAdministracionController.class).findAll()).withRel("all-recursos-administracion"));

        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<EntityModel<RecursoAdministracionDTO>> save(@RequestBody RecursoAdministracionDTO dto) throws Exception {
        RecursoAdministracion obj = service.save(modelMapper.map(dto, RecursoAdministracion.class));
        RecursoAdministracionDTO resultDto = modelMapper.map(obj, RecursoAdministracionDTO.class);

        EntityModel<RecursoAdministracionDTO> resource = EntityModel.of(resultDto);
        resource.add(linkTo(methodOn(RecursoAdministracionController.class).findById(obj.getIdRecursoAdministracion())).withSelfRel());
        resource.add(linkTo(methodOn(RecursoAdministracionController.class).findAll()).withRel("all-recursos-administracion"));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdRecursoAdministracion())
                .toUri();

        return ResponseEntity.created(location).body(resource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<RecursoAdministracionDTO>> update(@PathVariable Integer id,
                                                                        @RequestBody RecursoAdministracionDTO dto) throws Exception {
        RecursoAdministracion obj = service.update(modelMapper.map(dto, RecursoAdministracion.class), id);
        RecursoAdministracionDTO resultDto = modelMapper.map(obj, RecursoAdministracionDTO.class);

        EntityModel<RecursoAdministracionDTO> resource = EntityModel.of(resultDto);
        resource.add(linkTo(methodOn(RecursoAdministracionController.class).findById(id)).withSelfRel());
        resource.add(linkTo(methodOn(RecursoAdministracionController.class).findAll()).withRel("all-recursos-administracion"));

        return ResponseEntity.ok(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}