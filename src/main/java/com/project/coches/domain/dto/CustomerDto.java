package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Dto de un cliente
 */
@Getter @Setter
public class CustomerDto {
    private String carId;
    private String fullName;
    private String email;
    private Double numberCellphone;
    private Integer active;
    private String password;

}
