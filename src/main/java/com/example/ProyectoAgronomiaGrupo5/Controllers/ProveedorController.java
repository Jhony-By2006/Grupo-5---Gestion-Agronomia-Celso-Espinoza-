package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.dto.ProveedorDTO;
import com.example.ProyectoAgronomiaGrupo5.Models.Proveedor;
import com.example.ProyectoAgronomiaGrupo5.Service.IProveedorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Proveedor") // Tu ruta original respetando PascalCase
// @CrossOrigin(origins = "*")
public class ProveedorController {

    private final IProveedorService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ProveedorDTO>> findAll() throws Exception {
        // La banda transportadora idéntica a la del profesor
        List<ProveedorDTO> list = service.findAll().stream().map(e -> modelMapper.map(e, ProveedorDTO.class)).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorDTO> findById(@PathVariable Integer id) throws Exception {
        Proveedor obj = service.findById(id);

        return ResponseEntity.ok(modelMapper.map(obj, ProveedorDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ProveedorDTO dto) throws Exception {
        Proveedor obj = service.save(modelMapper.map(dto, Proveedor.class));

        // Construcción dinámica de la URL con el ID del proveedor
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdProveedor()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorDTO> update(@PathVariable Integer id, @RequestBody ProveedorDTO dto) throws Exception {
        Proveedor obj = service.update(modelMapper.map(dto, Proveedor.class), id);

        return ResponseEntity.ok(modelMapper.map(obj, ProveedorDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}