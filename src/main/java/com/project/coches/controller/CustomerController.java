package com.project.coches.controller;

import com.project.coches.domain.dto.CarBrandDto;
import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.dto.ResponseCustomerDto;
import com.project.coches.domain.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    private final ICustomerService iCustomerService;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll(){
        return ResponseEntity.ok(iCustomerService.getAll());
    }

    @GetMapping(path = "/{carId}")
    public ResponseEntity<CustomerDto> getCustomerByCardId(@PathVariable String carId){
        return ResponseEntity.of(iCustomerService.getCustomerByCardId(carId));
    }
    @GetMapping(path = "/email/{email}")
    public ResponseEntity<CustomerDto> getCustomerByEmail(@PathVariable String email){
        return ResponseEntity.of(iCustomerService.getCustomerByEmail(email));
    }

    @PostMapping
    public ResponseEntity<ResponseCustomerDto> save(@RequestBody CustomerDto customerDtoNew){
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(iCustomerService.save(customerDtoNew));
    }

    @PatchMapping
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customerUpdate) {
        return ResponseEntity.of(iCustomerService.update(customerUpdate));
    }

    @DeleteMapping(path = "/{carId}")
    public ResponseEntity<Boolean> delete(@PathVariable String carId){
        return new ResponseEntity<>(this.iCustomerService.delete(carId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
