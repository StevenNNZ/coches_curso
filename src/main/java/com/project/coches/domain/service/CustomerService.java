package com.project.coches.domain.service;

import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.dto.ResponseCustomerDto;
import com.project.coches.domain.repository.ICustomerRepository;
import com.project.coches.domain.useCase.ICustomerUseCase;
import com.project.coches.exception.EmailValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

/**
 * Servicio de cliente
 */
@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerUseCase {

    private final ICustomerRepository iCustomerRepository;

    @Override
    public List<CustomerDto> getAll() {
        return iCustomerRepository.getAll();
    }

    @Override
    public Optional<CustomerDto> getCustomerByCardId(String carId) {
        return iCustomerRepository.getCustomerByCardId(carId);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerRepository.getCustomerByEmail(email);
    }

    @Override
    public ResponseCustomerDto save(CustomerDto newCustomer) {

        if (!newCustomer.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            throw new EmailValidationException();
        }

        String passwordGenerated = generateRandomPassword(8);
        newCustomer.setPassword(passwordGenerated);
        newCustomer.setActive(1);
        iCustomerRepository.save(newCustomer);

        return new ResponseCustomerDto(passwordGenerated);
    }

    @Override
    public Optional<CustomerDto> update(CustomerDto updateCustomer) {
        if(iCustomerRepository.getCustomerByCardId(updateCustomer.getCarId()).isEmpty()){
            return Optional.empty();
        }

        return Optional.of(iCustomerRepository.save(updateCustomer));
    }


    @Override
    public boolean delete(String carId) {
        if(iCustomerRepository.getCustomerByCardId(carId).isEmpty()){
            return false;
        }

        iCustomerRepository.delete(carId);
        return true;
    }

    // Método para generar una contraseña alfanumérica aleatoria de una longitud específica
    private String generateRandomPassword(int len)
    {
        // Rango ASCII – alfanumérico (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        // cada iteración del bucle elige aleatoriamente un carácter del dado
        // rango ASCII y lo agrega a la instancia `StringBuilder`

        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }
}
