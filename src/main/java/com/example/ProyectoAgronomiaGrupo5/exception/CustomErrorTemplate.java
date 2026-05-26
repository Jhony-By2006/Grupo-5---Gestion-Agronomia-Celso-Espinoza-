package com.example.ProyectoAgronomiaGrupo5.exception;

import java.time.LocalDateTime;

public record CustomErrorTemplate(
        LocalDateTime datetime,
        String message,
        String details
) {
}