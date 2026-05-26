package com.example.ProyectoAgronomiaGrupo5.Repository;

import com.example.ProyectoAgronomiaGrupo5.Models.Inventario;
import org.springframework.stereotype.Repository;

@Repository
public interface IInventarioRepository extends IGenericRepository<Inventario, Integer> {
}