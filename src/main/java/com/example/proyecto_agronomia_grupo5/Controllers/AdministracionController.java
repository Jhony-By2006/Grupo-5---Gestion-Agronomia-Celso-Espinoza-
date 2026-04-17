package com.example.proyecto_agronomia_grupo5.Controllers;

import com.example.proyecto_agronomia_grupo5.Models.Administracion;
import com.example.proyecto_agronomia_grupo5.Service.IAdministracionService; //Service
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Administraciones") //chequear esto
@RequiredArgsConstructor

public class AdministracionController {
    private final IAdministracionService service; //AdministracionService

    @GetMapping
    public List<Administracion> findAll() throws  Exception{
        return service.findAll();
    }

    @PostMapping
    public  Administracion save(@RequestBody Administracion administracion) throws Exception{
        return service.save(administracion);
    }
    // @GetMapping("/{id}")
   //  @PutMapping("/{id}")
  //   @DeleteMapping("/{id}")


}
