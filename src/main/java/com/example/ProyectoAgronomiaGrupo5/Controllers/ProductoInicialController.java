package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.Models.ProductoInicial;
import com.example.ProyectoAgronomiaGrupo5.Service.IProductoInicialService;
import com.example.ProyectoAgronomiaGrupo5.dto.ProductoInicialDTO;
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
@RequestMapping("/ProductosIniciales")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProductoInicialController {

    private final IProductoInicialService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<EntityModel<ProductoInicialDTO>>> findAll() throws Exception {
        List<EntityModel<ProductoInicialDTO>> list = service.findAll()
                .stream()
                .map(e -> {
                    ProductoInicialDTO dto = modelMapper.map(e, ProductoInicialDTO.class);
                    EntityModel<ProductoInicialDTO> resource = EntityModel.of(dto);
                    try {
                        resource.add(linkTo(methodOn(ProductoInicialController.class).findById(e.getIdProductoInicial())).withSelfRel());
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    return resource;
                })
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ProductoInicialDTO>> findById(@PathVariable Integer id) throws Exception {
        ProductoInicial obj = service.findById(id);
        ProductoInicialDTO dto = modelMapper.map(obj, ProductoInicialDTO.class);

        EntityModel<ProductoInicialDTO> resource = EntityModel.of(dto);
        resource.add(linkTo(methodOn(ProductoInicialController.class).findById(id)).withSelfRel());
        resource.add(linkTo(methodOn(ProductoInicialController.class).findAll()).withRel("all-productos-iniciales"));

        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<EntityModel<ProductoInicialDTO>> save(@RequestBody ProductoInicialDTO dto) throws Exception {
        ProductoInicial obj = service.save(modelMapper.map(dto, ProductoInicial.class));
        ProductoInicialDTO resultDto = modelMapper.map(obj, ProductoInicialDTO.class);

        EntityModel<ProductoInicialDTO> resource = EntityModel.of(resultDto);
        resource.add(linkTo(methodOn(ProductoInicialController.class).findById(obj.getIdProductoInicial())).withSelfRel());
        resource.add(linkTo(methodOn(ProductoInicialController.class).findAll()).withRel("all-productos-iniciales"));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdProductoInicial())
                .toUri();
        return ResponseEntity.created(location).body(resource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<ProductoInicialDTO>> update(@PathVariable Integer id,
                                                                  @RequestBody ProductoInicialDTO dto) throws Exception {
        ProductoInicial obj = service.update(modelMapper.map(dto, ProductoInicial.class), id);
        ProductoInicialDTO resultDto = modelMapper.map(obj, ProductoInicialDTO.class);

        EntityModel<ProductoInicialDTO> resource = EntityModel.of(resultDto);
        resource.add(linkTo(methodOn(ProductoInicialController.class).findById(id)).withSelfRel());
        resource.add(linkTo(methodOn(ProductoInicialController.class).findAll()).withRel("all-productos-iniciales"));

        return ResponseEntity.ok(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}