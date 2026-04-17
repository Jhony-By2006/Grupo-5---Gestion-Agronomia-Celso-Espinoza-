package com.example.proyecto_agronomia_grupo5.Repository;


import com.example.proyecto_agronomia_grupo5.Models.Administracion; //Modelos

import org.springframework.data.jpa.repository.JpaRepository; //JpaRepository

public interface IAdministracionRepository extends JpaRepository <Administracion, Integer> {

}
