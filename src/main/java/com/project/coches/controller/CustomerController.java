package com.project.coches.controller;

import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.dto.ResponseCustomerDto;
import com.project.coches.domain.useCase.ICustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    private final ICustomerUseCase iCustomerUseCase;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll(){
        return ResponseEntity.ok(iCustomerUseCase.getAll());
    }

    @GetMapping(path = "/{carId}")
    public ResponseEntity<CustomerDto> getCustomerByCardId(@PathVariable String carId){
        return ResponseEntity.of(iCustomerUseCase.getCustomerByCardId(carId));
    }
    @GetMapping(path = "/email/{email}")
    public ResponseEntity<CustomerDto> getCustomerByEmail(@PathVariable String email){
        return ResponseEntity.of(iCustomerUseCase.getCustomerByEmail(email));
    }

    @PostMapping
    public ResponseEntity<ResponseCustomerDto> save(@RequestBody CustomerDto customerDtoNew){
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(iCustomerUseCase.save(customerDtoNew));
    }

    @PatchMapping
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customerUpdate) {
        return ResponseEntity.of(iCustomerUseCase.update(customerUpdate));
    }

    @DeleteMapping(path = "/{carId}")
    public ResponseEntity<Boolean> delete(@PathVariable String carId){
        return new ResponseEntity<>(this.iCustomerUseCase.delete(carId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
