package com.example.proyecto_agronomia_grupo5.Repository;

import com.example.proyecto_agronomia_grupo5.Models.Metodo_pago; //Modelos

import org.springframework.data.jpa.repository.JpaRepository; //JpaRepository

public interface IMetodo_pagoRepository  extends JpaRepository <Metodo_pago, Integer>{
}
