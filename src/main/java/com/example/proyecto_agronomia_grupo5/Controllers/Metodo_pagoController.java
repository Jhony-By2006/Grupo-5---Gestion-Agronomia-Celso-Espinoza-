package com.example.proyecto_agronomia_grupo5.Controllers;

import com.example.proyecto_agronomia_grupo5.Models.Metodo_pago;
import com.example.proyecto_agronomia_grupo5.Service.IMetodo_pagoService; //Service
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Indica que esta clase devuelva datos (JSON) y no páginas web
@RequestMapping("/Metodo_pago") //Define la dirección web o URL para acceder a esa tabla.
@RequiredArgsConstructor //Genera el constructor para que Spring inyecte el Service automáticamente.

public class Metodo_pagoController {
    private final IMetodo_pagoService service; //Es el jefe, contiene la lógica del negocio.

    @GetMapping//Se actuva cuando alguien entra a la URL.
    public List<Metodo_pago> findAll() throws  Exception{
        return service.findAll(); //Le pide al jefe que es service que traiga todos los registros
    }

    @GetMapping("/{id}") //actua cuando alguien entra a la URL con un ID
    public Metodo_pago findById(@PathVariable Integer id) throws Exception {
        return service.findById(id);
    }

    @PostMapping//actua cuando alguien envia datos es como un guardar de nuevo

    public Metodo_pago save(@RequestBody Metodo_pago metodo_pago) throws Exception{
        return service.save(metodo_pago);
    }

    @PutMapping("/{id}") //actua cuando alguien envia datos es como un actualizador
    public Metodo_pago update(@PathVariable Integer id, @RequestBody Metodo_pago metodo_pago) throws Exception {
        return service.update(metodo_pago, id);
    }

    @DeleteMapping("/{id}") //actua cuando alguien envia datos es como un borrador
    public void delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
    }
}
