package org.raoamigos.ecommerceordermanagement.controller;

import lombok.RequiredArgsConstructor;
import org.raoamigos.ecommerceordermanagement.dto.ShipmentResponseDTO;
import org.raoamigos.ecommerceordermanagement.service.ShipmentService;
import org.raoamigos.ecommerceordermanagement.service.impl.ShipmentServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shipment")
@RequiredArgsConstructor
public class ShipmentController {

    private final ShipmentService shipmentService;

    @GetMapping("/{id}")
    public ShipmentResponseDTO getShipmentById(@PathVariable  Long id) {
        return shipmentService.getShipmentById(id);
    }
}
