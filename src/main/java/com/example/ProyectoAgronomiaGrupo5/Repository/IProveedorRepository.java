package com.example.ProyectoAgronomiaGrupo5.Repository;

import com.example.ProyectoAgronomiaGrupo5.Models.Proveedor; //Modelos

import org.springframework.data.jpa.repository.JpaRepository; //JpaRepository

public interface IProveedorRepository extends JpaRepository <Proveedor, Integer> {
}
