package com.example.ProyectoAgronomiaGrupo5.Controllers;

import com.example.ProyectoAgronomiaGrupo5.Models.MetodoPago;
import com.example.ProyectoAgronomiaGrupo5.Service.IMetodoPagoService; //Service
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Indica que esta clase devuelva datos (JSON) y no páginas web
@RequestMapping("/Metodo_pago") //Define la dirección web o URL para acceder a esa tabla.
@RequiredArgsConstructor //Genera el constructor para que Spring inyecte el Service automáticamente.

public class MetodoPagoController {
    private final IMetodoPagoService service; //Es el jefe, contiene la lógica del negocio.

    @GetMapping//Se actuva cuando alguien entra a la URL.
    public List<MetodoPago> findAll() throws  Exception{
        return service.findAll(); //Le pide al jefe que es service que traiga todos los registros
    }

    @GetMapping("/{id}") //actua cuando alguien entra a la URL con un ID
    public MetodoPago findById(@PathVariable Integer id) throws Exception {
        return service.findById(id);
    }

    @PostMapping//actua cuando alguien envia datos es como un guardar de nuevo

    public MetodoPago save(@RequestBody MetodoPago metodo_pago) throws Exception{
        return service.save(metodo_pago);
    }

    @PutMapping("/{id}") //actua cuando alguien envia datos es como un actualizador
    public MetodoPago update(@PathVariable Integer id, @RequestBody MetodoPago metodo_pago) throws Exception {
        return service.update(metodo_pago, id);
    }

    @DeleteMapping("/{id}") //actua cuando alguien envia datos es como un borrador
    public void delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
    }
}
