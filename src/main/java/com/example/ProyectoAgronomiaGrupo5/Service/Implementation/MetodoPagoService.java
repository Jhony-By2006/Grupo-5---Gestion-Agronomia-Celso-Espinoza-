package com.example.ProyectoAgronomiaGrupo5.Service.Implementation;

import com.example.ProyectoAgronomiaGrupo5.Models.MetodoPago; //Modelos
import com.example.ProyectoAgronomiaGrupo5.Repository.IMetodoPagoRepository; //Repositorio
import com.example.ProyectoAgronomiaGrupo5.Service.IMetodoPagoService; //Servicio
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //Crea automáticamente un constructor para todos los campos,es como una independencia
public class MetodoPagoService implements IMetodoPagoService {
    //Autowired
    private final IMetodoPagoRepository repo;
    @Override
    public MetodoPago save(MetodoPago metodo_pago) throws Exception {

        return repo.save(metodo_pago);
    }

    @Override
    public MetodoPago update(MetodoPago metodo_pago, Integer id) throws Exception {
        // En un update, primero verificamos que exista,
        // Con spring detecta que si el ID existe,debe actualizar en lugar de crear uno nuevo
        metodo_pago.setId_metodo_pago(id);
        return repo.save(metodo_pago);
    }
    @Override
    public List<MetodoPago> findAll() throws Exception {
        // Trae todos los registros de la tabla
        return repo.findAll();
    }
    @Override
    public MetodoPago findById(Integer id) throws Exception {
        // Busca por ID, si no lo encuentra, crea un objeto vacio en lugar de devolver null
        return repo.findById(id).orElse(new MetodoPago());
    }

    @Override
    public void delete(Integer id) throws Exception {
        // Borra el registro de la base de datos
        repo.deleteById(id);
    }
}

