package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidad de marca coche
 */
@Getter
@Setter
@Entity
@Table(name = "marca_coche")

public class CarBrandEntity {

    /**
     * Id de la marca
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Descripción de la marca
     */
    @Column(name = "descripcion")
    private String description;

    @OneToMany(mappedBy = "carBrandEntity", orphanRemoval = true)
    private List<CarEntity> carEntities;

}
