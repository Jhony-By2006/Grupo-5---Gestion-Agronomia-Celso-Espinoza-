package com.example.proyecto_agronomia_grupo5.Service.Implementation;

import com.example.proyecto_agronomia_grupo5.Models.Metodo_pago; //Modelos
import com.example.proyecto_agronomia_grupo5.Repository.IMetodo_pagoRepository; //Repositorio
import com.example.proyecto_agronomia_grupo5.Service.IMetodo_pagoService; //Servicio
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //Crea automáticamente un constructor para todos los campos,es como una independencia
public class Metodo_pagoService implements IMetodo_pagoService {
    //Autowired
    private final IMetodo_pagoRepository repo;
    @Override
    public Metodo_pago save(Metodo_pago metodo_pago) throws Exception {

        return repo.save(metodo_pago);
    }

    @Override
    public Metodo_pago update(Metodo_pago metodo_pago, Integer id) throws Exception {
        // En un update, primero verificamos que exista,
        // Con spring detecta que si el ID existe,debe actualizar en lugar de crear uno nuevo
        metodo_pago.setId_metodo_pago(id);
        return repo.save(metodo_pago);
    }
    @Override
    public List<Metodo_pago> findAll() throws Exception {
        // Trae todos los registros de la tabla
        return repo.findAll();
    }
    @Override
    public Metodo_pago findById(Integer id) throws Exception {
        // Busca por ID, si no lo encuentra, crea un objeto vacio en lugar de devolver null
        return repo.findById(id).orElse(new Metodo_pago());
    }

    @Override
    public void delete(Integer id) throws Exception {
        // Borra el registro de la base de datos
        repo.deleteById(id);
    }
}

