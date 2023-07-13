package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


/**
 * Entidad de un cliente
 */
@Getter @Setter
@Entity
@Table(name ="clientes")
public class CustomerEntity {
    @Id
    @Column(name = "cedula")
    private String carId;

    @Column(name = "nombre_completo")
    private String fullName;

    @Column(name = "correo")
    private String email;

    @Column(name = "numero_celular")
    private Double numberCellphone;

    @Column(name = "activo")
    private Integer active;

    @Column(name = "contrasenia")
    private String password;
}
