package com.project.coches.domain.repository;

import com.project.coches.domain.dto.CarBrandDto;

import java.util.List;
import java.util.Optional;

/**
 * Interface del repositorio de marca coche
 */
public interface ICarBrandRepository {

    /**
     * Devuelve una lista con todas las marcas de coches
     * @return Lista con marcas de coches
     */
    List<CarBrandDto> getAll();

    /**
     * Devuelve una marca de coche dada su id
     * @param id Id de marca coche
     * @return Optional del marca coche encontrado
     */
    Optional<CarBrandDto> getCarBrand(Integer id);

    /**
     * Guarda una nueva marca coche
     * @param newBrandCard Marca coche a guardar
     * @return Marca coche guardada
     */
    CarBrandDto save(CarBrandDto newBrandCard);

    /**
     * Elimina una marca coche dado su id
     * @param idBrandCard id del mara coche a eliminar
     */
    void delete(Integer idBrandCard);
}
