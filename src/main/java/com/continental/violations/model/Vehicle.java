package com.continental.violations.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vehicle {
    @Id
    private String vehicleNumber;

    @OneToOne
    @MapsId
    private Owner owner;

    private Date purchasedDate;

    private String color;
}
