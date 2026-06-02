package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.dto.ReporteDTO;
import com.example.ProyectoAgronomiaGrupo5.Models.Reporte;
import com.example.ProyectoAgronomiaGrupo5.Service.IReporteService;
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
@RequestMapping("/reportes")
@CrossOrigin(origins = "*")
public class ReporteController {

    private final IReporteService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<EntityModel<ReporteDTO>>> findAll() throws Exception {
        List<EntityModel<ReporteDTO>> list = service.findAll().stream()
                .map(e -> {
                    ReporteDTO dto = modelMapper.map(e, ReporteDTO.class);
                    EntityModel<ReporteDTO> resource = EntityModel.of(dto);
                    try {
                        resource.add(linkTo(methodOn(ReporteController.class).findById(e.getIdReporte())).withSelfRel());
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    return resource;
                })
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ReporteDTO>> findById(@PathVariable Integer id) throws Exception {
        Reporte obj = service.findById(id);
        ReporteDTO dto = modelMapper.map(obj, ReporteDTO.class);

        EntityModel<ReporteDTO> resource = EntityModel.of(dto);
        resource.add(linkTo(methodOn(ReporteController.class).findById(id)).withSelfRel());
        resource.add(linkTo(methodOn(ReporteController.class).findAll()).withRel("all-reportes"));

        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<EntityModel<ReporteDTO>> save(@RequestBody ReporteDTO dto) throws Exception {
        Reporte obj = service.save(modelMapper.map(dto, Reporte.class));
        ReporteDTO resultDto = modelMapper.map(obj, ReporteDTO.class);

        EntityModel<ReporteDTO> resource = EntityModel.of(resultDto);
        resource.add(linkTo(methodOn(ReporteController.class).findById(obj.getIdReporte())).withSelfRel());
        resource.add(linkTo(methodOn(ReporteController.class).findAll()).withRel("all-reportes"));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdReporte())
                .toUri();
        return ResponseEntity.created(location).body(resource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<ReporteDTO>> update(@PathVariable Integer id, @RequestBody ReporteDTO dto) throws Exception {
        Reporte obj = service.update(modelMapper.map(dto, Reporte.class), id);
        ReporteDTO resultDto = modelMapper.map(obj, ReporteDTO.class);

        EntityModel<ReporteDTO> resource = EntityModel.of(resultDto);
        resource.add(linkTo(methodOn(ReporteController.class).findById(id)).withSelfRel());
        resource.add(linkTo(methodOn(ReporteController.class).findAll()).withRel("all-reportes"));

        return ResponseEntity.ok(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}