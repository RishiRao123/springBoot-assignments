package org.raoamigos.ecommerceordermanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.raoamigos.ecommerceordermanagement.dto.ShipmentRequestDTO;
import org.raoamigos.ecommerceordermanagement.dto.ShipmentResponseDTO;
import org.raoamigos.ecommerceordermanagement.entity.Shipment;
import org.raoamigos.ecommerceordermanagement.entity.Warehouse;
import org.raoamigos.ecommerceordermanagement.enums.ShipmentStatus;
import org.raoamigos.ecommerceordermanagement.repository.ShipmentRepository;
import org.raoamigos.ecommerceordermanagement.repository.WarehouseRepository;
import org.raoamigos.ecommerceordermanagement.service.ShipmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final WarehouseRepository warehouseRepository;

    @Override
    public ShipmentResponseDTO createShipment(ShipmentRequestDTO dto) {
//        Warehouse warehouse = warehouseRepository.findById(dto.getWarehouseId())
//                .orElseThrow(() -> new RuntimeException("Warehouse not found with id: " + dto.getWarehouseId()));
//
//        Shipment shipment = Shipment.builder()
//                .trackingNumber(dto.getTrackingNumber())
//                .customerEmail(dto.getCustomerEmail())
//                .status(ShipmentStatus.PENDING)
//                .warehouse(warehouse)
//                .build();
//        Shipment savedShipment = shipmentRepository.save(shipment);

//        return mapToResponseDTO(savedShipment);
        return null;
    }

    @Override
    public ShipmentResponseDTO getShipmentById(Long id) {

        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment not found with id: " + id));

        return mapToResponseDTO(shipment);
    }

    @Override
    public Page<ShipmentResponseDTO> getAllShipments(Pageable pageable) {
        Page<Shipment> shipments = shipmentRepository.findAll(pageable);

        return shipments.map(this::mapToResponseDTO);
    }

    @Override
    public ShipmentResponseDTO updateShipment(Long id, ShipmentRequestDTO dto) {
        Shipment existing = shipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment not found with id: " + id));


        Warehouse warehouse = warehouseRepository.findById(dto.getWarehouseId())
                .orElseThrow(() -> new RuntimeException("Warehouse not found with id: " + dto.getWarehouseId()));

        existing.setTrackingNumber(dto.getTrackingNumber());
        existing.setCustomerEmail(
                dto.getCustomerEmail());
        existing.setWarehouse(warehouse);

        Shipment updatedShipment = shipmentRepository.save(existing);

        return mapToResponseDTO(updatedShipment);
    }

    @Override
    public void deleteShipmentById(Long id) {
        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment not found with id: " + id));

        shipmentRepository.delete(shipment);
    }

    private ShipmentResponseDTO mapToResponseDTO(Shipment shipment) {
        return ShipmentResponseDTO.builder()
                .id(shipment.getId())
                .trackingNumber(shipment.getTrackingNumber())
                .status(shipment.getStatus().name())
                .customerEmail(shipment.getCustomerEmail())
                .warehouseName(
                        shipment.getWarehouse() != null
                                ? shipment.getWarehouse().getName()
                                : null
                )
                .build();
    }

}
