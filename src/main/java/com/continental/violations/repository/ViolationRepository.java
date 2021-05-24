package com.continental.violations.repository;

import com.continental.violations.model.Violation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViolationRepository extends CrudRepository<Violation, Integer> {

    @Query("select v from Violation v where v.vehicleNumber in (:numbers)")
    List<Violation> getViolationsByVehicleNumber(@Param("numbers") List<String> vehicleNumbers);
}
