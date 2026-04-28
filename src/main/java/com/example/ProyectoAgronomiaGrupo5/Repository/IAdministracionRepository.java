package com.example.ProyectoAgronomiaGrupo5.Repository;


import com.example.ProyectoAgronomiaGrupo5.Models.Administracion; //Modelos

import org.springframework.data.jpa.repository.JpaRepository; //JpaRepository

public interface IAdministracionRepository extends JpaRepository <Administracion, Integer> {

}
