package com.example.ProyectoAgronomiaGrupo5.security;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuthorizeLogic {
    public boolean hasAccess(String permiso) {
        boolean hasAccess = false;

        String methodRole = switch (permiso) {

            // Para cosas como Inventario, Productos (lo que ven ambos)
            case "ACCESO_COMPARTIDO" -> "ROLE_ADMIN,ROLE_TRABAJADOR";

            // Para cosas exclusivas de Administración y Trabajadores
            case "ACCESO_ADMIN" -> "ROLE_ADMIN";

            default -> "ROLE_ADMIN"; // Si te olvidas de poner algo, por seguridad solo entra el Admin
        };

        String[] methodRoles = methodRole.split(",");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // El resto de tu lógica de validación se queda igualita...
        for (GrantedAuthority ga : auth.getAuthorities()) {
            String roleUser = ga.getAuthority();
            for (String role : methodRoles) {
                if (roleUser.equalsIgnoreCase(role)) {
                    hasAccess = true;
                    break;
                }
            }
        }
        return hasAccess;
    }
}