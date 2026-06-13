package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.dto.MetodoPagoDTO;
import com.example.ProyectoAgronomiaGrupo5.Models.MetodoPago;
import com.example.ProyectoAgronomiaGrupo5.Service.IMetodoPagoService;
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
@RequestMapping("/MetodoPago")
@CrossOrigin(origins = "*")
public class MetodoPagoController {

    private final IMetodoPagoService service;
    private final ModelMapper modelMapper;
    @PreAuthorize("@authorizeLogic.hasAccess('findAll')")
    @GetMapping
    public ResponseEntity<List<EntityModel<MetodoPagoDTO>>> findAll() throws Exception {
        List<EntityModel<MetodoPagoDTO>> list = service.findAll()
                .stream()
                .map(e -> {
                    MetodoPagoDTO dto = modelMapper.map(e, MetodoPagoDTO.class);
                    EntityModel<MetodoPagoDTO> resource = EntityModel.of(dto);
                    try {
                        resource.add(linkTo(methodOn(MetodoPagoController.class).findById(e.getIdMetodoPago())).withSelfRel());
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    return resource;
                })
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<MetodoPagoDTO>> findById(@PathVariable Integer id) throws Exception {
        MetodoPago obj = service.findById(id);
        MetodoPagoDTO dto = modelMapper.map(obj, MetodoPagoDTO.class);

        EntityModel<MetodoPagoDTO> resource = EntityModel.of(dto);
        resource.add(linkTo(methodOn(MetodoPagoController.class).findById(id)).withSelfRel());
        resource.add(linkTo(methodOn(MetodoPagoController.class).findAll()).withRel("all-metodos-pago"));

        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<EntityModel<MetodoPagoDTO>> save(@RequestBody MetodoPagoDTO dto) throws Exception {
        MetodoPago obj = service.save(modelMapper.map(dto, MetodoPago.class));
        MetodoPagoDTO resultDto = modelMapper.map(obj, MetodoPagoDTO.class);

        EntityModel<MetodoPagoDTO> resource = EntityModel.of(resultDto);
        resource.add(linkTo(methodOn(MetodoPagoController.class).findById(obj.getIdMetodoPago())).withSelfRel());
        resource.add(linkTo(methodOn(MetodoPagoController.class).findAll()).withRel("all-metodos-pago"));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdMetodoPago())
                .toUri();
        return ResponseEntity.created(location).body(resource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<MetodoPagoDTO>> update(@PathVariable Integer id, @RequestBody MetodoPagoDTO dto) throws Exception {
        MetodoPago obj = service.update(modelMapper.map(dto, MetodoPago.class), id);
        MetodoPagoDTO resultDto = modelMapper.map(obj, MetodoPagoDTO.class);

        EntityModel<MetodoPagoDTO> resource = EntityModel.of(resultDto);
        resource.add(linkTo(methodOn(MetodoPagoController.class).findById(id)).withSelfRel());
        resource.add(linkTo(methodOn(MetodoPagoController.class).findAll()).withRel("all-metodos-pago"));

        return ResponseEntity.ok(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}