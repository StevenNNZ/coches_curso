package com.project.coches.domain.useCase;

import com.project.coches.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ICarUseCase {

    List<CarDto> getAll();

    Optional<CarDto> getCar(Integer idCar);

    List<CarDto> getByIdBrandCar(Integer idBrandCar);

    List<CarDto> getCarsByPriceLessThan(Double price);


    CarDto save(CarDto newCar);

    boolean delete(Integer idCar);
}
