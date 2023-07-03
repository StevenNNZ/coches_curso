package com.project.coches.controller;

import com.project.coches.domain.pojo.CarBrandPojo;
import com.project.coches.domain.service.ICarBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/marcas-coches")
public class CarBrandController {

    /**
     * Servicio de marca coche
     */
    private final ICarBrandService iCarBrandService;

    @GetMapping
    public ResponseEntity<List<CarBrandPojo>> getAll(){

        return ResponseEntity.ok(iCarBrandService.getAll());

        //return  ResponseEntity.status(HttpStatus.OK).body(iCarBrandService.getAll());
        //return new ResponseEntity<>(iCarBrandService.getAll(), HttpStatus.OK); Alternativa para crear response entity
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CarBrandPojo> getCarBrand(@PathVariable Integer id){
        return ResponseEntity.of(iCarBrandService.getCarBrand(id));
    }

    @PostMapping
    public ResponseEntity<CarBrandPojo> save(@RequestBody CarBrandPojo carBrandPojoNew){
        try{

            return  ResponseEntity.status(HttpStatus.CREATED).body(iCarBrandService.save(carBrandPojoNew));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
