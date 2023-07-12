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

    /**
     * Devuelve lista de marcas coche
     * @return HttpCode OK con lista de marcas coche
     */
    @GetMapping
    public ResponseEntity<List<CarBrandPojo>> getAll(){

        return ResponseEntity.ok(iCarBrandService.getAll());

        //return  ResponseEntity.status(HttpStatus.OK).body(iCarBrandService.getAll());
        //return new ResponseEntity<>(iCarBrandService.getAll(), HttpStatus.OK); Alternativa para crear response entity
    }

    /**
     * Devuelve una marca coche dado su id
     * @param id id marcaCoche a buscar
     * @return HttpCode OK si la encuentra, HttpCode Nout Found de lo contrario
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<CarBrandPojo> getCarBrand(@PathVariable Integer id){
        return ResponseEntity.of(iCarBrandService.getCarBrand(id));
    }

    /**
     * Crea una nueva marca coche
     * @param carBrandPojoNew marcaCoche a crear
     * @return HttpCode Created si lo guarda correctamente, HttpCode BadRequest de lo contrario
     */
    @PostMapping
    public ResponseEntity<CarBrandPojo> save(@RequestBody CarBrandPojo carBrandPojoNew){
        try{
            return  ResponseEntity.status(HttpStatus.CREATED).body(iCarBrandService.save(carBrandPojoNew));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    /**
     * Actualiza una marca coche
     * @param carBrandPojoUpdate Obj marca coche a actuaizar
     * @return httpCode Ok si lo actualiza correctamente
     */
    @PatchMapping
    public ResponseEntity<CarBrandPojo> update(@RequestBody CarBrandPojo carBrandPojoUpdate) {
        return ResponseEntity.of(iCarBrandService.update(carBrandPojoUpdate));
    }


    /**
     * Elimina una marca de coche dado su id
     * @param id marcaCoche a eliminar
     * @return HttpCode Ok si la elimina, httpCode NotFound si no existe
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iCarBrandService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
