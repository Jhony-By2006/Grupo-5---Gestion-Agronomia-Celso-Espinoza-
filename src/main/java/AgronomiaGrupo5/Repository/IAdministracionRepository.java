package AgronomiaGrupo5.Repository;


import AgronomiaGrupo5.Models.Administracion; //Modelos

import org.springframework.data.jpa.repository.JpaRepository; //JpaRepository

public interface IAdministracionRepository extends JpaRepository <Administracion, Integer> {

}
