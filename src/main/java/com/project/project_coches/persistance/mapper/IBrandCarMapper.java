package com.project.project_coches.persistance.mapper;

import com.project.project_coches.domain.pojo.BrandCarPojo;
import com.project.project_coches.persistance.entity.BrandCarEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper que transforma objetos de marcaCoche a pojos o entidades
 */

@Mapper(componentModel = "spring")
public interface IBrandCarMapper {

    /**
     * convierte una entidad a un pojo de marca coche
     * @param marcaEntity Entidad a convertir
     * @return pojo convertido
     */
    @Mapping(source = "id", target="id")
    @Mapping(source = "description", target="description")
    BrandCarPojo toMarcaCochePojo(BrandCarEntity marcaEntity);

    /**
     * convierte un pojo a una entidad de marcaCoche
     * @param marcaPojo pojo a convertir
     * @return entity convertido
     */
    @InheritInverseConfiguration
    BrandCarEntity toMarcaCocheEntity(BrandCarPojo marcaPojo);

    /**
     * Retorna una lista de marcas coche transformada a pojo de una lista de entidades
     * @param marcasCocheEntity Entidad a transformar
     * @return lista transformada
     */
    List<BrandCarPojo> toMarcasCochePojo(List<BrandCarEntity> marcasCocheEntity);

}
