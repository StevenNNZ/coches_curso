package com.project.coches.domain.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * Pojo de marca coche
 */
@Getter @Setter
public class CarBrandPojo {

    /**
     * Id de la marca
     */
    private Integer id;

    /**
     * Descripción de la marca
     */
    private String description;
}
