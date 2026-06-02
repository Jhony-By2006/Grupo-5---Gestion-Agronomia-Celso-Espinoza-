package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.dto.ProveedorDTO;
import com.example.ProyectoAgronomiaGrupo5.Models.Proveedor;
import com.example.ProyectoAgronomiaGrupo5.Service.IProveedorService;
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
@RequiredArgsConstructor
@RequestMapping("/Proveedor")
@CrossOrigin(origins = "*")
public class ProveedorController {

    private final IProveedorService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<EntityModel<ProveedorDTO>>> findAll() throws Exception {
        List<EntityModel<ProveedorDTO>> list = service.findAll().stream().map(e -> {
            ProveedorDTO dto = modelMapper.map(e, ProveedorDTO.class);
            EntityModel<ProveedorDTO> resource = EntityModel.of(dto);
            try {
                resource.add(linkTo(methodOn(ProveedorController.class).findById(e.getIdProveedor())).withSelfRel());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            return resource;
        }).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ProveedorDTO>> findById(@PathVariable Integer id) throws Exception {
        Proveedor obj = service.findById(id);
        ProveedorDTO dto = modelMapper.map(obj, ProveedorDTO.class);

        EntityModel<ProveedorDTO> resource = EntityModel.of(dto);
        resource.add(linkTo(methodOn(ProveedorController.class).findById(id)).withSelfRel());
        resource.add(linkTo(methodOn(ProveedorController.class).findAll()).withRel("all-proveedores"));

        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<EntityModel<ProveedorDTO>> save(@RequestBody ProveedorDTO dto) throws Exception {
        Proveedor obj = service.save(modelMapper.map(dto, Proveedor.class));
        ProveedorDTO resultDto = modelMapper.map(obj, ProveedorDTO.class);

        EntityModel<ProveedorDTO> resource = EntityModel.of(resultDto);
        resource.add(linkTo(methodOn(ProveedorController.class).findById(obj.getIdProveedor())).withSelfRel());
        resource.add(linkTo(methodOn(ProveedorController.class).findAll()).withRel("all-proveedores"));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdProveedor()).toUri();

        return ResponseEntity.created(location).body(resource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<ProveedorDTO>> update(@PathVariable Integer id, @RequestBody ProveedorDTO dto) throws Exception {
        Proveedor obj = service.update(modelMapper.map(dto, Proveedor.class), id);
        ProveedorDTO resultDto = modelMapper.map(obj, ProveedorDTO.class);

        EntityModel<ProveedorDTO> resource = EntityModel.of(resultDto);
        resource.add(linkTo(methodOn(ProveedorController.class).findById(id)).withSelfRel());
        resource.add(linkTo(methodOn(ProveedorController.class).findAll()).withRel("all-proveedores"));

        return ResponseEntity.ok(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}