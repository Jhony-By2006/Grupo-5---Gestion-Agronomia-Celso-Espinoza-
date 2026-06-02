package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.dto.ProductoFinalDTO;
import com.example.ProyectoAgronomiaGrupo5.Models.ProductoFinal;
import com.example.ProyectoAgronomiaGrupo5.Service.IProductoFinalService;
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
@RequestMapping("/ProductosFinales")
@CrossOrigin(origins = "*")
public class ProductoFinalController {

    private final IProductoFinalService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<EntityModel<ProductoFinalDTO>>> findAll() throws Exception {
        List<EntityModel<ProductoFinalDTO>> list = service.findAll()
                .stream()
                .map(e -> {
                    ProductoFinalDTO dto = modelMapper.map(e, ProductoFinalDTO.class);
                    EntityModel<ProductoFinalDTO> resource = EntityModel.of(dto);
                    try {
                        resource.add(linkTo(methodOn(ProductoFinalController.class).findById(e.getIdProductoFinal())).withSelfRel());
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    return resource;
                })
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ProductoFinalDTO>> findById(@PathVariable Integer id) throws Exception {
        ProductoFinal obj = service.findById(id);
        ProductoFinalDTO dto = modelMapper.map(obj, ProductoFinalDTO.class);

        EntityModel<ProductoFinalDTO> resource = EntityModel.of(dto);
        resource.add(linkTo(methodOn(ProductoFinalController.class).findById(id)).withSelfRel());
        resource.add(linkTo(methodOn(ProductoFinalController.class).findAll()).withRel("all-productos-finales"));

        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<EntityModel<ProductoFinalDTO>> save(@RequestBody ProductoFinalDTO dto) throws Exception {
        ProductoFinal obj = service.save(modelMapper.map(dto, ProductoFinal.class));
        ProductoFinalDTO resultDto = modelMapper.map(obj, ProductoFinalDTO.class);

        EntityModel<ProductoFinalDTO> resource = EntityModel.of(resultDto);
        resource.add(linkTo(methodOn(ProductoFinalController.class).findById(obj.getIdProductoFinal())).withSelfRel());
        resource.add(linkTo(methodOn(ProductoFinalController.class).findAll()).withRel("all-productos-finales"));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdProductoFinal())
                .toUri();
        return ResponseEntity.created(location).body(resource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<ProductoFinalDTO>> update(@PathVariable Integer id, @RequestBody ProductoFinalDTO dto) throws Exception {
        ProductoFinal obj = service.update(modelMapper.map(dto, ProductoFinal.class), id);
        ProductoFinalDTO resultDto = modelMapper.map(obj, ProductoFinalDTO.class);

        EntityModel<ProductoFinalDTO> resource = EntityModel.of(resultDto);
        resource.add(linkTo(methodOn(ProductoFinalController.class).findById(id)).withSelfRel());
        resource.add(linkTo(methodOn(ProductoFinalController.class).findAll()).withRel("all-productos-finales"));

        return ResponseEntity.ok(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}