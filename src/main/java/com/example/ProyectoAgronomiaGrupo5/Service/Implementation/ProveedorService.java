package com.example.proyecto_agronomia_grupo5.Service.Implementation;

import com.example.proyecto_agronomia_grupo5.Models.Proveedor; //Modelos
import com.example.proyecto_agronomia_grupo5.Repository.IProveedorRepository; //Repositorio
import com.example.proyecto_agronomia_grupo5.Service.IProveedorService; //Servicio
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //Crea automáticamente un constructor para todos los campos,es como una independencia
public class ProveedorService implements IProveedorService {
    //Autowired
    private final IProveedorRepository repo;
    @Override
    public Proveedor save(Proveedor proveedor) throws Exception {

        return repo.save(proveedor);
    }

    @Override
    public Proveedor update(Proveedor proveedor, Integer id) throws Exception {
        // En un update, primero verificamos que exista,
        // Con spring detecta que si el ID existe,debe actualizar en lugar de crear uno nuevo
        proveedor.setIdProveedor(id);
        return repo.save(proveedor);
    }
    @Override
    public List<Proveedor> findAll() throws Exception {
        // Trae todos los registros de la tabla
        return repo.findAll();
    }
    @Override
    public Proveedor findById(Integer id) throws Exception {
        // Busca por ID, si no lo encuentra, crea un objeto vacio en lugar de devolver null
        return repo.findById(id).orElse(new Proveedor());
    }

    @Override
    public void delete(Integer id) throws Exception {
        // Borra el registro de la base de datos
        repo.deleteById(id);
    }
}

