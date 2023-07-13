package com.project.coches.persistance.repository;

import com.project.coches.domain.dto.CarDto;
import com.project.coches.domain.repository.ICarRepository;
import com.project.coches.persistance.crud.ICarCrudRepository;
import com.project.coches.persistance.mapper.ICarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CarRepository implements ICarRepository {

    private final ICarCrudRepository iCarCrudRepository;
    private final ICarMapper iCarMapper;

    @Override
    public List<CarDto> getAll() {
        return null;
    }

    @Override
    public Optional<CarDto> getCar(Integer idCar) {
        return Optional.empty();
    }

    @Override
    public List<CarDto> getByIdBrandCar(Integer idBrandCar) {
        return null;
    }

    @Override
    public List<CarDto> getCarsByPriceLessThan(Double price) {
        return null;
    }

    @Override
    public CarDto save(CarDto newCar) {
        return null;
    }

    @Override
    public void delete(Integer idCar) {

    }
}
