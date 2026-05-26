package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.Models.Administracion;
import com.example.ProyectoAgronomiaGrupo5.Service.IAdministracionService; //Service
import com.example.ProyectoAgronomiaGrupo5.dto.AdministracionDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController //Indica que esta clase devuelva datos (JSON) y no páginas web
@RequestMapping("/Administracion") //Define la dirección web o URL para acceder a esa tabla.
@RequiredArgsConstructor //Genera el constructor para que Spring inyecte el Service automáticamente.

// @CrossOrigin(origins = "*") //Lo que hace es que angular pueda pedirle datos al backend sin se que se el navegador de bloquee por seguridad

public class AdministracionController {

    private final IAdministracionService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<AdministracionDTO>> findAll() throws Exception {
        List<AdministracionDTO> list = service.findAll()
                .stream()
                .map(e -> modelMapper.map(e, AdministracionDTO.class))
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministracionDTO> findById(@PathVariable Integer id) throws Exception {
        Administracion obj = service.findById(id);
        return ResponseEntity.ok(modelMapper.map(obj, AdministracionDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody AdministracionDTO dto) throws Exception {
        Administracion obj = service.save(modelMapper.map(dto, Administracion.class));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdAdministracion())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdministracionDTO> update(@PathVariable Integer id, @RequestBody AdministracionDTO dto) throws Exception {
        Administracion obj = service.update(modelMapper.map(dto, Administracion.class), id);
        return ResponseEntity.ok(modelMapper.map(obj, AdministracionDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
    /*
    @GetMapping//Se actuva cuando alguien entra a la URL.
    public List<Administracion> findAll() throws  Exception{
        return service.findAll(); //Le pide al jefe que es service que traiga todos los registros
    }

    @GetMapping("/{id}") //actua cuando alguien entra a la URL con un ID
    public Administracion findById(@PathVariable Integer id) throws Exception {
        return service.findById(id);
    }

    @PostMapping//actua cuando alguien envia datos es como un guardar de nuevo

    public  Administracion save(@RequestBody Administracion administracion) throws Exception{
        return service.save(administracion);
    }

    @PutMapping("/{id}") //actua cuando alguien envia datos es como un actualizador
    public Administracion update(@PathVariable Integer id, @RequestBody Administracion administracion) throws Exception {
        return service.update(administracion, id);
    }

    @DeleteMapping("/{id}") //actua cuando alguien envia datos es como un borrador
    public void delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
    }

     */

