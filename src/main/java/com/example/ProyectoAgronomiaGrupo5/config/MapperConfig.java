package com.example.ProyectoAgronomiaGrupo5.config;

import com.example.ProyectoAgronomiaGrupo5.Models.Administracion;
import com.example.ProyectoAgronomiaGrupo5.dto.AdministracionDTO;
import com.example.ProyectoAgronomiaGrupo5.Models.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ModelMapper administracionMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);

            // ── LECTURA: Administracion -> AdministracionDTO ──
                TypeMap<Administracion, AdministracionDTO> readMap =
                        mapper.createTypeMap(Administracion.class, AdministracionDTO.class);

                readMap.addMapping(src -> src.getIdAdministracion(),       AdministracionDTO::setIdAdministracion);
                readMap.addMapping(src -> src.getNombre(),                  AdministracionDTO::setNombre);
                readMap.addMapping(src -> src.getDescripcion(),             AdministracionDTO::setDescripcion);
                readMap.addMapping(src -> src.getFechaRegistro(),           AdministracionDTO::setFechaRegistro);
                readMap.addMapping(src -> src.getResponsable(),             AdministracionDTO::setResponsable);
                readMap.addMapping(src -> src.getEstadoAdmin(),             AdministracionDTO::setEstadoAdmin);
                readMap.addMapping(src -> src.getInventario().getIdInventario(),                               AdministracionDTO::setIdInventario);
                readMap.addMapping(src -> src.getRecursoAdministracion().getIdRecursoAdministracion(),         AdministracionDTO::setIdRecursoAdministracion);
                readMap.addMapping(src -> src.getReporte().getIdReporte(),                                     AdministracionDTO::setIdReporte);
                readMap.addMapping(src -> src.getTrabajador().getIdTrabajador(),                               AdministracionDTO::setIdTrabajador);
                readMap.addMapping(src -> src.getMetodoPago().getIdMetodoPago(),                               AdministracionDTO::setIdMetodoPago);

        // ── ESCRITURA: AdministracionDTO -> Administracion ──
        mapper.createTypeMap(AdministracionDTO.class, Administracion.class)
                .addMappings(m -> {
                    m.using(ctx -> {
                        Integer id = (Integer) ctx.getSource();
                        if (id == null) return null;
                        Inventario inv = new Inventario();
                        inv.setIdInventario(id);
                        return inv;
                    }).map(AdministracionDTO::getIdInventario, Administracion::setInventario);

                    m.using(ctx -> {
                        Integer id = (Integer) ctx.getSource();
                        if (id == null) return null;
                        RecursoAdministracion rec = new RecursoAdministracion();
                        rec.setIdRecursoAdministracion(id);
                        return rec;
                    }).map(AdministracionDTO::getIdRecursoAdministracion, Administracion::setRecursoAdministracion);

                    m.using(ctx -> {
                        Integer id = (Integer) ctx.getSource();
                        if (id == null) return null;
                        Reporte rep = new Reporte();
                        rep.setIdReporte(id);
                        return rep;
                    }).map(AdministracionDTO::getIdReporte, Administracion::setReporte);

                    m.using(ctx -> {
                        Integer id = (Integer) ctx.getSource();
                        if (id == null) return null;
                        Trabajador trab = new Trabajador();
                        trab.setIdTrabajador(id);
                        return trab;
                    }).map(AdministracionDTO::getIdTrabajador, Administracion::setTrabajador);

                    m.using(ctx -> {
                        Integer id = (Integer) ctx.getSource();
                        if (id == null) return null;
                        MetodoPago mp = new MetodoPago();
                        mp.setIdMetodoPago(id);
                        return mp;
                    }).map(AdministracionDTO::getIdMetodoPago, Administracion::setMetodoPago);
                });

        return mapper;
    }
}