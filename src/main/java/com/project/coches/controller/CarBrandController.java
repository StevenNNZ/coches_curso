package com.project.coches.controller;

import com.project.coches.domain.dto.CarBrandDto;
import com.project.coches.domain.useCase.ICarBrandUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/car-brand")
public class CarBrandController {

    /**
     * Servicio de marca coche
     */
    private final ICarBrandUseCase iCarBrandUseCase;

    /**
     * Devuelve lista de marcas coche
     * @return HttpCode OK con lista de marcas coche
     */
    @GetMapping
    public ResponseEntity<List<CarBrandDto>> getAll(){

        return ResponseEntity.ok(iCarBrandUseCase.getAll());

        //return  ResponseEntity.status(HttpStatus.OK).body(iCarBrandUseCase.getAll());
        //return new ResponseEntity<>(iCarBrandUseCase.getAll(), HttpStatus.OK); Alternativa para crear response entity
    }

    /**
     * Devuelve una marca coche dado su id
     * @param id id marcaCoche a buscar
     * @return HttpCode OK si la encuentra, HttpCode Nout Found de lo contrario
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<CarBrandDto> getCarBrand(@PathVariable Integer id){
        return ResponseEntity.of(iCarBrandUseCase.getCarBrand(id));
    }

    /**
     * Crea una nueva marca coche
     * @param carBrandDtoNew marcaCoche a crear
     * @return HttpCode Created si lo guarda correctamente, HttpCode BadRequest de lo contrario
     */
    @PostMapping
    public ResponseEntity<CarBrandDto> save(@RequestBody CarBrandDto carBrandDtoNew){
        try{
            return  ResponseEntity.status(HttpStatus.CREATED).body(iCarBrandUseCase.save(carBrandDtoNew));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    /**
     * Actualiza una marca coche
     * @param carBrandDtoUpdate Obj marca coche a actuaizar
     * @return httpCode Ok si lo actualiza correctamente
     */
    @PatchMapping
    public ResponseEntity<CarBrandDto> update(@RequestBody CarBrandDto carBrandDtoUpdate) {
        return ResponseEntity.of(iCarBrandUseCase.update(carBrandDtoUpdate));
    }


    /**
     * Elimina una marca de coche dado su id
     * @param id marcaCoche a eliminar
     * @return HttpCode Ok si la elimina, httpCode NotFound si no existe
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iCarBrandUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
