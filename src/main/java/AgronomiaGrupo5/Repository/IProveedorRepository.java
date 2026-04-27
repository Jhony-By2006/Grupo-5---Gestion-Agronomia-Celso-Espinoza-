package AgronomiaGrupo5.Repository;

import AgronomiaGrupo5.Models.Proveedor; //Modelos

import org.springframework.data.jpa.repository.JpaRepository; //JpaRepository

public interface IProveedorRepository extends JpaRepository <Proveedor, Integer> {
}
