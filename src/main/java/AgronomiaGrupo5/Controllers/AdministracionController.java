package AgronomiaGrupo5.Controllers;

import AgronomiaGrupo5.Models.Administracion;
import AgronomiaGrupo5.Service.IAdministracionService; //Service
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Indica que esta clase devuelva datos (JSON) y no páginas web
@RequestMapping("/Administraciones") //Define la dirección web o URL para acceder a esa tabla.
@RequiredArgsConstructor //Genera el constructor para que Spring inyecte el Service automáticamente.


public class AdministracionController {
    private final IAdministracionService service; //Es el jefe, contiene la lógica del negocio.

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
}
