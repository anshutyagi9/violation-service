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
public class Violation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String vehicleNumber;

    String violationType;

    @Temporal(TemporalType.DATE)
    Date violationDate = new Date();

    float penaltyAmount;
}
