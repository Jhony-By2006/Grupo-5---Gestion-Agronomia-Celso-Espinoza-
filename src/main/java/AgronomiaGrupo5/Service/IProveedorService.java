package AgronomiaGrupo5.Service;

import AgronomiaGrupo5.Models.Proveedor; //Modelos

import java.util.List;

public interface IProveedorService {
    // 1. Guardar un nuevo Proveedor
    Proveedor save(Proveedor proveedor) throws Exception;

    // 2. Actualizar una existente (pasando el objeto y su ID)
    Proveedor update(Proveedor proveedor, Integer id) throws Exception;

    // 3. Listar todos los registros
    List<Proveedor> findAll() throws Exception;

    // 4. Buscar un Proveedor específico por su ID
    Proveedor findById(Integer id) throws Exception;

    // 5. Eliminar un Proveedor
    void delete(Integer id) throws Exception;

}

