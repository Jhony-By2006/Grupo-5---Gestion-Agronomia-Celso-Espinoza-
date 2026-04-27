package AgronomiaGrupo5.Repository;

import AgronomiaGrupo5.Models.MetodoPago; //Modelos

import org.springframework.data.jpa.repository.JpaRepository; //JpaRepository

public interface IMetodoPagoRepository extends JpaRepository <MetodoPago, Integer>{
}
