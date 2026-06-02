package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.Models.Inventario;
import com.example.ProyectoAgronomiaGrupo5.Service.IInventarioService;
import com.example.ProyectoAgronomiaGrupo5.dto.InventarioDTO;
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
@RequestMapping("/Inventario")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class InventarioController {

    private final IInventarioService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<EntityModel<InventarioDTO>>> findAll() throws Exception {
        List<EntityModel<InventarioDTO>> list = service.findAll()
                .stream()
                .map(e -> {
                    InventarioDTO dto = modelMapper.map(e, InventarioDTO.class);
                    EntityModel<InventarioDTO> resource = EntityModel.of(dto);
                    try {
                        resource.add(linkTo(methodOn(InventarioController.class).findById(e.getIdInventario())).withSelfRel());
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    return resource;
                })
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<InventarioDTO>> findById(@PathVariable Integer id) throws Exception {
        Inventario obj = service.findById(id);
        InventarioDTO dto = modelMapper.map(obj, InventarioDTO.class);

        EntityModel<InventarioDTO> resource = EntityModel.of(dto);
        resource.add(linkTo(methodOn(InventarioController.class).findById(id)).withSelfRel());
        resource.add(linkTo(methodOn(InventarioController.class).findAll()).withRel("all-inventarios"));

        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<EntityModel<InventarioDTO>> save(@RequestBody InventarioDTO dto) throws Exception {
        Inventario obj = service.save(modelMapper.map(dto, Inventario.class));
        InventarioDTO resultDto = modelMapper.map(obj, InventarioDTO.class);

        EntityModel<InventarioDTO> resource = EntityModel.of(resultDto);
        resource.add(linkTo(methodOn(InventarioController.class).findById(obj.getIdInventario())).withSelfRel());
        resource.add(linkTo(methodOn(InventarioController.class).findAll()).withRel("all-inventarios"));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdInventario())
                .toUri();
        return ResponseEntity.created(location).body(resource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<InventarioDTO>> update(@PathVariable Integer id, @RequestBody InventarioDTO dto) throws Exception {
        Inventario obj = service.update(modelMapper.map(dto, Inventario.class), id);
        InventarioDTO resultDto = modelMapper.map(obj, InventarioDTO.class);

        EntityModel<InventarioDTO> resource = EntityModel.of(resultDto);
        resource.add(linkTo(methodOn(InventarioController.class).findById(id)).withSelfRel());
        resource.add(linkTo(methodOn(InventarioController.class).findAll()).withRel("all-inventarios"));

        return ResponseEntity.ok(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}