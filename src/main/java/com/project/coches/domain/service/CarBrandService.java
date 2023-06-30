package com.project.coches.domain.service;

import com.project.coches.domain.pojo.CarBrandPojo;
import com.project.coches.domain.repository.ICarBrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * Servicio de marca coche
 */
@RequiredArgsConstructor
@Service
public class CarBrandService implements ICarBrandService{

    private final ICarBrandRepository iCarBrandRepository;

    @Override
    public List<CarBrandPojo> getAll() {
        return iCarBrandRepository.getAll();
    }

    @Override
    public Optional<CarBrandPojo> getCarBrand(Integer id) {
        return iCarBrandRepository.getCarBrand(id);
    }

    @Override
    public CarBrandPojo save(CarBrandPojo newBrandCard) {
        return iCarBrandRepository.save(newBrandCard);
    }

    @Override
    public boolean delete(Integer idBrandCard) {
        try{
            iCarBrandRepository.delete(idBrandCard);
            return true;
        }catch (Exception e){
        return false;
        }
    }
}
