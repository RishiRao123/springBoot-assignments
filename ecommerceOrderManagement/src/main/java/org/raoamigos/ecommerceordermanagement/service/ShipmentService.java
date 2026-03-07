package org.raoamigos.ecommerceordermanagement.service;

import org.raoamigos.ecommerceordermanagement.dto.ShipmentRequestDTO;
import org.raoamigos.ecommerceordermanagement.dto.ShipmentResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ShipmentService {

    ShipmentResponseDTO createShipment(ShipmentRequestDTO dto);
    ShipmentResponseDTO getShipmentById(Long id);
    Page<ShipmentResponseDTO> getAllShipments(Pageable pageable);
    ShipmentResponseDTO updateShipment(Long id, ShipmentRequestDTO dto);
    void deleteShipmentById(Long id);

}
