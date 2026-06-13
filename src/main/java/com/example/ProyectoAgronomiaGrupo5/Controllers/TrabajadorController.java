package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.dto.TrabajadorDTO;
import com.example.ProyectoAgronomiaGrupo5.Models.Trabajador;
import com.example.ProyectoAgronomiaGrupo5.Service.ITrabajadorService;
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
@RequestMapping("/Trabajadores")
@CrossOrigin(origins = "*")

public class TrabajadorController {

    private final ITrabajadorService service;
    private final ModelMapper modelMapper;
    @PreAuthorize("hasRole('ADMIN')")

    @GetMapping
    public ResponseEntity<List<EntityModel<TrabajadorDTO>>> findAll() throws Exception {
        List<EntityModel<TrabajadorDTO>> list = service.findAll().stream().map(e -> {
            TrabajadorDTO dto = modelMapper.map(e, TrabajadorDTO.class);
            EntityModel<TrabajadorDTO> resource = EntityModel.of(dto);
            try {
                resource.add(linkTo(methodOn(TrabajadorController.class).findById(e.getIdTrabajador())).withSelfRel());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            return resource;
        }).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<TrabajadorDTO>> findById(@PathVariable Integer id) throws Exception {
        Trabajador obj = service.findById(id);
        TrabajadorDTO dto = modelMapper.map(obj, TrabajadorDTO.class);

        EntityModel<TrabajadorDTO> resource = EntityModel.of(dto);
        resource.add(linkTo(methodOn(TrabajadorController.class).findById(id)).withSelfRel());
        resource.add(linkTo(methodOn(TrabajadorController.class).findAll()).withRel("all-trabajadores"));

        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<EntityModel<TrabajadorDTO>> save(@RequestBody TrabajadorDTO dto) throws Exception {
        Trabajador obj = service.save(modelMapper.map(dto, Trabajador.class));
        TrabajadorDTO resultDto = modelMapper.map(obj, TrabajadorDTO.class);

        EntityModel<TrabajadorDTO> resource = EntityModel.of(resultDto);
        resource.add(linkTo(methodOn(TrabajadorController.class).findById(obj.getIdTrabajador())).withSelfRel());
        resource.add(linkTo(methodOn(TrabajadorController.class).findAll()).withRel("all-trabajadores"));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTrabajador()).toUri();

        return ResponseEntity.created(location).body(resource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<TrabajadorDTO>> update(@PathVariable Integer id, @RequestBody TrabajadorDTO dto) throws Exception {
        Trabajador obj = service.update(modelMapper.map(dto, Trabajador.class), id);
        TrabajadorDTO resultDto = modelMapper.map(obj, TrabajadorDTO.class);

        EntityModel<TrabajadorDTO> resource = EntityModel.of(resultDto);
        resource.add(linkTo(methodOn(TrabajadorController.class).findById(id)).withSelfRel());
        resource.add(linkTo(methodOn(TrabajadorController.class).findAll()).withRel("all-trabajadores"));

        return ResponseEntity.ok(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}