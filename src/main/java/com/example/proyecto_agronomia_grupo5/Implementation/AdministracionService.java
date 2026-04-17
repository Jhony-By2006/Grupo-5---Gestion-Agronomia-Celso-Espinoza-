package com.example.proyecto_agronomia_grupo5.Implementation;

import com.example.proyecto_agronomia_grupo5.Models.Administracion; //Modelos
import com.example.proyecto_agronomia_grupo5.Repository.IAdministracionRepository; //Repositorio
import com.example.proyecto_agronomia_grupo5.Service.IAdministracionService; //Servicio
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //Crea automáticamente un constructor para todos los campos,es como una independencia
public class AdministracionService implements IAdministracionService {
    //Autowired
    private IAdministracionRepository repo;
    @Override
    public Administracion save(Administracion administracion) throws Exception {

        return repo.save(administracion);
    }

    @Override
    public Administracion update(Administracion administracion, Integer id) throws Exception {
        // En un update, primero verificamos que exista,
        // Con spring detecta que si el ID existe,debe actualizar en lugar de crear uno nuevo
        return repo.save(administracion);
    }
    @Override
    public List<Administracion> findAll() throws Exception {
        // Trae todos los registros de la tabla
        return repo.findAll();
    }
    @Override
    public Administracion findById(Integer id) throws Exception {
        // Busca por ID, si no lo encuentra, crea un objeto vacio en lugar de devolver null
        return repo.findById(id).orElse(new Administracion());
    }

    @Override
    public void delete(Integer id) throws Exception {
        // Borra el registro de la base de datos
        repo.deleteById(id);
    }
}
