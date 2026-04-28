package com.example.ProyectoAgronomiaGrupo5.Repository;

import com.example.ProyectoAgronomiaGrupo5.Models.MetodoPago; //Modelos

import org.springframework.data.jpa.repository.JpaRepository; //JpaRepository

public interface IMetodoPagoRepository extends JpaRepository <MetodoPago, Integer>{
}
