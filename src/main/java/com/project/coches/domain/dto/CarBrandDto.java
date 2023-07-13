package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Pojo de marca coche
 */
@Getter @Setter
public class CarBrandDto {

    /**
     * Id de la marca
     */
    private Integer id;

    /**
     * Descripción de la marca
     */
    private String description;
}
