package com.example.proyecto_agronomia_grupo5.Controllers;

import com.example.proyecto_agronomia_grupo5.Models.Proveedor;
import com.example.proyecto_agronomia_grupo5.Service.IProveedorService; //Service
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Indica que esta clase devuelva datos (JSON) y no páginas web
@RequestMapping("/Proveedores") //Define la dirección web o URL para acceder a esa tabla.
@RequiredArgsConstructor //Genera el constructor para que Spring inyecte el Service automáticamente.


public class ProveedorController {
    private final IProveedorService service; //Es el jefe, contiene la lógica del negocio.

    @GetMapping//Se actuva cuando alguien entra a la URL.
    public List<Proveedor> findAll() throws  Exception{
        return service.findAll(); //Le pide al jefe que es service que traiga todos los registros
    }

    @GetMapping("/{id}") //actua cuando alguien entra a la URL con un ID
    public Proveedor findById(@PathVariable Integer id) throws Exception {
        return service.findById(id);
    }

    @PostMapping//actua cuando alguien envia datos es como un guardar de nuevo

    public  Proveedor save(@RequestBody Proveedor proveedor) throws Exception{
        return service.save(proveedor);
    }

    @PutMapping("/{id}") //actua cuando alguien envia datos es como un actualizador
    public Proveedor update(@PathVariable Integer id, @RequestBody Proveedor proveedor) throws Exception {
        return service.update(proveedor, id);
    }

    @DeleteMapping("/{id}") //actua cuando alguien envia datos es como un borrador
    public void delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
    }

}

