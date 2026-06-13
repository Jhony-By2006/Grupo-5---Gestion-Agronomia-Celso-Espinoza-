package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.dto.PagoDTO;
import com.example.ProyectoAgronomiaGrupo5.Models.Pago;
import com.example.ProyectoAgronomiaGrupo5.Service.IPagoService;
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
@RequestMapping("/pagos")
@CrossOrigin(origins = "*")
public class PagoController {

    private final IPagoService service;
    private final ModelMapper modelMapper;
    @PreAuthorize("@authorizeLogic.hasAccess('findAll')")

    @GetMapping
    public ResponseEntity<List<EntityModel<PagoDTO>>> findAll() throws Exception {
        List<EntityModel<PagoDTO>> list = service.findAll()
                .stream()
                .map(e -> {
                    PagoDTO dto = modelMapper.map(e, PagoDTO.class);
                    EntityModel<PagoDTO> resource = EntityModel.of(dto);
                    try {
                        resource.add(linkTo(methodOn(PagoController.class).findById(e.getIdPago())).withSelfRel());
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    return resource;
                })
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<PagoDTO>> findById(@PathVariable Integer id) throws Exception {
        Pago obj = service.findById(id);
        PagoDTO dto = modelMapper.map(obj, PagoDTO.class);

        EntityModel<PagoDTO> resource = EntityModel.of(dto);
        resource.add(linkTo(methodOn(PagoController.class).findById(id)).withSelfRel());
        resource.add(linkTo(methodOn(PagoController.class).findAll()).withRel("all-pagos"));

        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<EntityModel<PagoDTO>> save(@RequestBody PagoDTO dto) throws Exception {
        Pago obj = service.save(modelMapper.map(dto, Pago.class));
        PagoDTO resultDto = modelMapper.map(obj, PagoDTO.class);

        EntityModel<PagoDTO> resource = EntityModel.of(resultDto);
        resource.add(linkTo(methodOn(PagoController.class).findById(obj.getIdPago())).withSelfRel());
        resource.add(linkTo(methodOn(PagoController.class).findAll()).withRel("all-pagos"));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdPago())
                .toUri();
        return ResponseEntity.created(location).body(resource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<PagoDTO>> update(@PathVariable Integer id, @RequestBody PagoDTO dto) throws Exception {
        Pago obj = service.update(modelMapper.map(dto, Pago.class), id);
        PagoDTO resultDto = modelMapper.map(obj, PagoDTO.class);

        EntityModel<PagoDTO> resource = EntityModel.of(resultDto);
        resource.add(linkTo(methodOn(PagoController.class).findById(id)).withSelfRel());
        resource.add(linkTo(methodOn(PagoController.class).findAll()).withRel("all-pagos"));

        return ResponseEntity.ok(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}