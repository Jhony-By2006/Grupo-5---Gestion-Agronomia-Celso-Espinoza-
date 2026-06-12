package com.example.ProyectoAgronomiaGrupo5.Service.Implementation;

import com.example.ProyectoAgronomiaGrupo5.Models.Usuario;
import com.example.ProyectoAgronomiaGrupo5.Repository.IGenericRepository;
import com.example.ProyectoAgronomiaGrupo5.Repository.IUsuarioRepository;
import com.example.ProyectoAgronomiaGrupo5.Service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService extends GenericService<Usuario, Integer> implements IUsuarioService {

    private final IUsuarioRepository repo;
    private final PasswordEncoder bcrypt;

    @Override
    protected IGenericRepository<Usuario, Integer> getRepo() {
        return repo;
    }

    @Override
    public Usuario findOneByUsername(String username) {
        return repo.findOneByUsername(username);
    }

    @Override
    public void changePassword(String username, String newPassword) {
        repo.changePassword(username, bcrypt.encode(newPassword));
    }
}