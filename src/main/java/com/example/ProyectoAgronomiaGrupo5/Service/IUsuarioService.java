package com.example.ProyectoAgronomiaGrupo5.Service;

import com.example.ProyectoAgronomiaGrupo5.Models.Usuario;

public interface IUsuarioService extends IGenericService<Usuario, Integer> {

    Usuario findOneByUsername(String username);

    void changePassword(String username, String password);
}