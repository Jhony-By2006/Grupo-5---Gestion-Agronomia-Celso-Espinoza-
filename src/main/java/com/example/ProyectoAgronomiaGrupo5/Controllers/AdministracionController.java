package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.Models.Administracion;
import com.example.ProyectoAgronomiaGrupo5.Service.IAdministracionService;
import com.example.ProyectoAgronomiaGrupo5.dto.AdministracionDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/Administracion")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AdministracionController {

    private final IAdministracionService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<EntityModel<AdministracionDTO>>> findAll() throws Exception {
        List<EntityModel<AdministracionDTO>> list = service.findAll()
                .stream()
                .map(e -> {
                    AdministracionDTO dto = modelMapper.map(e, AdministracionDTO.class);
                    EntityModel<AdministracionDTO> resource = EntityModel.of(dto);
                    try {
                        resource.add(linkTo(methodOn(AdministracionController.class).findById(e.getIdAdministracion())).withSelfRel());
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    return resource;
                })
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<AdministracionDTO>> findById(@PathVariable Integer id) throws Exception {
        Administracion obj = service.findById(id);
        AdministracionDTO dto = modelMapper.map(obj, AdministracionDTO.class);

        EntityModel<AdministracionDTO> resource = EntityModel.of(dto);
        resource.add(linkTo(methodOn(AdministracionController.class).findById(id)).withSelfRel());
        resource.add(linkTo(methodOn(AdministracionController.class).findAll()).withRel("all-administracion"));

        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<EntityModel<AdministracionDTO>> save(@RequestBody AdministracionDTO dto) throws Exception {
        Administracion obj = service.save(modelMapper.map(dto, Administracion.class));
        AdministracionDTO resultDto = modelMapper.map(obj, AdministracionDTO.class);

        EntityModel<AdministracionDTO> resource = EntityModel.of(resultDto);
        resource.add(linkTo(methodOn(AdministracionController.class).findById(obj.getIdAdministracion())).withSelfRel());
        resource.add(linkTo(methodOn(AdministracionController.class).findAll()).withRel("all-administracion"));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdAdministracion())
                .toUri();
        return ResponseEntity.created(location).body(resource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<AdministracionDTO>> update(@PathVariable Integer id, @RequestBody AdministracionDTO dto) throws Exception {
        Administracion obj = service.update(modelMapper.map(dto, Administracion.class), id);
        AdministracionDTO resultDto = modelMapper.map(obj, AdministracionDTO.class);

        EntityModel<AdministracionDTO> resource = EntityModel.of(resultDto);
        resource.add(linkTo(methodOn(AdministracionController.class).findById(id)).withSelfRel());
        resource.add(linkTo(methodOn(AdministracionController.class).findAll()).withRel("all-administracion"));

        return ResponseEntity.ok(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}