package com.project.coches.domain.service;

import com.project.coches.domain.pojo.CarBrandPojo;

import java.util.List;
import java.util.Optional;

public interface ICarBrandService {

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
     * Actualiza una marca coche
     * @param updateBrandCard Marca coche a actualizar
     * @return marca coche actualizada
     */
    Optional<CarBrandPojo> update(CarBrandPojo updateBrandCard);

    /**
     * Elimina una marca coche dado su id
     * @param idBrandCard id del mara coche a eliminar
     */
    boolean delete(Integer idBrandCard);
}
