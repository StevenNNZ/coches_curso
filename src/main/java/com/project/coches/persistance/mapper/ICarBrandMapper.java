package com.project.coches.persistance.mapper;

import com.project.coches.domain.pojo.CarBrandPojo;
import com.project.coches.persistance.entity.CarBrandEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Maper que transforma objetos de MarcaCoche a pojos o entidades
 */
@Mapper(componentModel =  "spring")
public interface ICarBrandMapper {

    //En este caso poner el mapping es redundante, ya que en ambos casos tienen el mismo nombre
    //Si fueran diferentes, podríamos omitir el mapping
    /**
     * Convierte una entidad a un pojo de marca coche
     * @param marcaEntity Entidad a convertir
     * @return Pojo convertido
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    CarBrandPojo toMarcaCochePojo(CarBrandEntity marcaEntity);

    /**
     * Convierte un pojo a una entidad de marca coche
     * @param marcaPojo Pojo a convertir
     * @return Entity convertido
     */
    @InheritInverseConfiguration
    CarBrandEntity toMarcaCocheEntity(CarBrandPojo marcaPojo);

    /**
     * Retorna una lista de marcas coche transformada a pojo de una lista de entidades
     * @param marcasCocheEntity entidad a transformar
     * @return Lista transformada
     */
    List<CarBrandPojo> toMarcasCochePojo(List<CarBrandEntity> marcasCocheEntity);
}
