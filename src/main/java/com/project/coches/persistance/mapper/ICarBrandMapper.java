package com.project.coches.persistance.mapper;

import com.project.coches.domain.dto.CarBrandDto;
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
     * Convierte una entidad a un dto de marca coche
     * @param marcaEntity Entidad a convertir
     * @return Pojo convertido
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    CarBrandDto toMarcaCochePojo(CarBrandEntity marcaEntity);

    /**
     * Convierte un dto a una entidad de marca coche
     * @param marcaPojo Pojo a convertir
     * @return Entity convertido
     */
    @InheritInverseConfiguration
    @Mapping(target = "carEntities", ignore = true)
    CarBrandEntity toMarcaCocheEntity(CarBrandDto marcaPojo);

    /**
     * Retorna una lista de marcas coche transformada a dto de una lista de entidades
     * @param marcasCocheEntity entidad a transformar
     * @return Lista transformada
     */
    List<CarBrandDto> toMarcasCochePojo(List<CarBrandEntity> marcasCocheEntity);
}
