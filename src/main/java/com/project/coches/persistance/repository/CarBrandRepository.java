package com.project.coches.persistance.repository;

import com.project.coches.domain.dto.CarBrandDto;
import com.project.coches.domain.repository.ICarBrandRepository;
import com.project.coches.persistance.crud.ICarBrandCrudRepository;
import com.project.coches.persistance.entity.CarBrandEntity;
import com.project.coches.persistance.mapper.ICarBrandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * Repositorio de marca coche
 */
@RequiredArgsConstructor //Crea constructor con los atributos final
@Repository
public class CarBrandRepository implements ICarBrandRepository {

    /**
     * Crud de marca coche
     */
    private final ICarBrandCrudRepository iCarBrandCrudRepository;

    /**
     * Mapper de marca coche
     */
    private final ICarBrandMapper iCarBrandMapper;

    /**
     * Devuelve una lista con todas las marcas de coches
     * @return Lista con marcas de coches
     */
    @Override
    public List<CarBrandDto> getAll() {
        return iCarBrandMapper.toMarcasCochePojo(iCarBrandCrudRepository.findAll());
    }

    /**
     * Devuelve una marca de coche dada su id
     * @param id Id de marca coche
     * @return Optional del marca coche encontrado
     */
    @Override
    public Optional<CarBrandDto> getCarBrand(Integer id) {
        return iCarBrandCrudRepository.findById(id)
                .map(iCarBrandMapper::toMarcaCochePojo);

        // .map(brandCarEntity -> iCarBrandMapper.toMarcaCochePojo(brandCarEntity)) == lambda
        //  .map(iCarBrandMapper::toMarcaCochePojo); == referencia
    }

    /**
     * Guarda una nueva marca coche
     * @param newBrandCard Marca coche a guardar
     * @return Marca coche guardada
     */
    @Override
    public CarBrandDto save(CarBrandDto newBrandCard) {
        CarBrandEntity carBrandEntity = iCarBrandMapper.toMarcaCocheEntity(newBrandCard);
        return iCarBrandMapper.toMarcaCochePojo(iCarBrandCrudRepository.save(carBrandEntity));
    }

    /**
     * Elimina una marca coche dado su id
     * @param idBrandCard id del mara coche a eliminar
     */
    @Override
    public void delete(Integer idBrandCard) {
        iCarBrandCrudRepository.deleteById(idBrandCard);
    }
}
