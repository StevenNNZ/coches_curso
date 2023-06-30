package com.project.coches.domain.repository;

import com.project.coches.domain.pojo.CarBrandPojo;

import java.util.List;
import java.util.Optional;

public interface ICarBrandRepository {

    /**
     * Devuelve una lista con todas las marcas de coches
     * @return Lista con marcas de coches
     */
    List<CarBrandPojo> getAll();

    /**
     * Devuelve una marca de coche dada su id
     * @param id Id de marca coche
     * @return Optional del marca coche encontrado
     */
    Optional<CarBrandPojo> getCarBrand(Integer id);

    /**
     * Guarda una nueva marca coche
     * @param newBrandCard Marca coche a guardar
     * @return Marca coche guardada
     */
    CarBrandPojo save(CarBrandPojo newBrandCard);

    /**
     * Elimina una marca coche dado su id
     * @param idBrandCard id del mara coche a eliminar
     */
    void delete(Integer idBrandCard);
}
