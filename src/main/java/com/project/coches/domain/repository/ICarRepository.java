package com.project.coches.domain.repository;

import com.project.coches.domain.dto.CarBrandDto;
import com.project.coches.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ICarRepository {
    List<CarDto> getAll();

    Optional<CarDto> getCar(Integer idCar);

    List<CarDto> getByIdBrandCar(Integer idBrandCar);

    List<CarDto> getCarsByPriceLessThan(Double price);


    CarDto save(CarDto newCar);

    void delete(Integer idCar);
}
