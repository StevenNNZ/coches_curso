package com.project.coches.domain.useCase;

import com.project.coches.domain.dto.CarBrandDto;

import java.util.List;
import java.util.Optional;

public interface ICarBrandUseCase {

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
     * Actualiza una marca coche
     * @param updateBrandCard Marca coche a actualizar
     * @return marca coche actualizada
     */
    Optional<CarBrandDto> update(CarBrandDto updateBrandCard);

    /**
     * Elimina una marca coche dado su id
     * @param idBrandCard id del mara coche a eliminar
     */
    boolean delete(Integer idBrandCard);
}
