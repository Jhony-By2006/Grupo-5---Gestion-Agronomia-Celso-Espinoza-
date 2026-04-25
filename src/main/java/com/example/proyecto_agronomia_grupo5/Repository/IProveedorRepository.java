package com.example.proyecto_agronomia_grupo5.Repository;

import com.example.proyecto_agronomia_grupo5.Models.Proveedor; //Modelos

import org.springframework.data.jpa.repository.JpaRepository; //JpaRepository

public interface IProveedorRepository extends JpaRepository <Proveedor, Integer> {
}
