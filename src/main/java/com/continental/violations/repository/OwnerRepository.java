package com.continental.violations.repository;

import com.continental.violations.model.Owner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Integer> {

    @Query("select emailAddress from Owner where vehicleNumber = ?1")
    String findEmailId(String vehicleNumber);
}
