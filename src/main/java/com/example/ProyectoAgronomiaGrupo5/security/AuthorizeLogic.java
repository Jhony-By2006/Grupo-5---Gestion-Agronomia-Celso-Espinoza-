package com.example.ProyectoAgronomiaGrupo5.security;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuthorizeLogic {
    public boolean hasAccess(String path) {
        boolean hasAccess = false;

        // ADMIN = acceso a todo
        // TRABAJADOR = solo Inventario, ProductoFinal, Reporte, Pago
        String methodRole = switch (path) {

            // ✅ TRABAJADOR + ADMIN tienen acceso
            case "findAll", "findById",
                 "save", "update", "delete" -> "ROLE_ADMIN,ROLE_TRABAJADOR";

            // ✅ Solo ADMIN tiene acceso
            case "adminOnly" -> "ROLE_ADMIN";

            default -> "ROLE_ADMIN";
        };

        String[] methodRoles = methodRole.split(",");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        log.info("Username is: {} ", auth.getName());

        for (GrantedAuthority ga : auth.getAuthorities()) {
            String roleUser = ga.getAuthority();
            log.info("Role is: {} ", roleUser);
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