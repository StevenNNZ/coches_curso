package com.project.coches.domain.service;

import com.project.coches.domain.dto.CarBrandDto;
import com.project.coches.domain.repository.ICarBrandRepository;
import com.project.coches.domain.useCase.ICarBrandUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * Servicio de marca coche
 */
@RequiredArgsConstructor
@Service
public class CarBrandService implements ICarBrandUseCase {

    /**
     * Repositorio de marca coche
     */
    private final ICarBrandRepository iCarBrandRepository;

    /**
     * Devuelve una lista con todas las marcas de coches
     * @return Lista con marcas de coches
     */
    @Override
    public List<CarBrandDto> getAll() {
        return iCarBrandRepository.getAll();
    }

    /**
     * Devuelve una marca de coche dada su id
     * @param id Id de marca coche
     * @return Optional del marca coche encontrado
     */
    @Override
    public Optional<CarBrandDto> getCarBrand(Integer id) {
        return iCarBrandRepository.getCarBrand(id);
    }

    /**
     * Guarda una nueva marca coche
     * @param newBrandCard Marca coche a guardar
     * @return Marca coche guardada
     */
    @Override
    public CarBrandDto save(CarBrandDto newBrandCard) {
        return iCarBrandRepository.save(newBrandCard);
    }

    /**
     *Actualiza una marca coche
     * @param updateBrandCard Marca coche a actualizar
     * @return Optional con marca coche actualizada
     */
    @Override
    public Optional<CarBrandDto> update(CarBrandDto updateBrandCard) {
        if(iCarBrandRepository.getCarBrand(updateBrandCard.getId()).isEmpty()){
            return Optional.empty();
        }

        return Optional.of(iCarBrandRepository.save(updateBrandCard));
    }

    /**
     * Elimina una marca coche dado su id
     * @param idBrandCard id del mara coche a eliminar
     * @return true si se eliminó, falso de lo contrario
     */
    @Override
    public boolean delete(Integer idBrandCard) {

        if(iCarBrandRepository.getCarBrand(idBrandCard).isEmpty()){
            return false;
        }

        iCarBrandRepository.delete(idBrandCard);
        return true;
    }
}
