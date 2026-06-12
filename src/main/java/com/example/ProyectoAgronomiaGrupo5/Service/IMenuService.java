package com.example.ProyectoAgronomiaGrupo5.Service;

import com.example.ProyectoAgronomiaGrupo5.Models.Menu;

import java.util.List;

public interface IMenuService extends IGenericService<Menu, Integer> {
    List<Menu> getMenusByUsername();
}