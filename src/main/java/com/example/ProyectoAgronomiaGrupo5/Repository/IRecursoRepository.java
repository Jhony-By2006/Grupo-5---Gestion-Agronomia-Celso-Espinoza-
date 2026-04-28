package com.example.proyecto_agronomia_grupo5.Repository;

import com.example.proyecto_agronomia_grupo5.Models.Recurso; //Modelos

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecursoRepository extends JpaRepository <Recurso, Integer>{
}
