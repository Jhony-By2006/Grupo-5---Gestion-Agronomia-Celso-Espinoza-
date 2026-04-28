package com.example.proyecto_agronomia_grupo5.Repository;

import com.example.proyecto_agronomia_grupo5.Models.MetodoPago; //Modelos

import org.springframework.data.jpa.repository.JpaRepository; //JpaRepository

public interface IMetodoPagoRepository extends JpaRepository <MetodoPago, Integer>{
}
