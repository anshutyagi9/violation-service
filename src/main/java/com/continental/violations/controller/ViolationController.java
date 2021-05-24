package com.continental.violations.controller;

import com.continental.violations.model.VehicleIdRequest;
import com.continental.violations.model.Violation;
import com.continental.violations.service.ViolationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1")
public class ViolationController {
    @Autowired
    ViolationService violationService;

    @PostMapping(value="/violations")
    public void createViolation(@RequestBody Violation violation){
        violationService.createViolation(violation);
    }

    @PostMapping(value="/vehicles/violations")
    public List<Violation> getViolations(@RequestBody VehicleIdRequest vehicleIdRequest){
        return violationService.getViolations(vehicleIdRequest);
    }


}
