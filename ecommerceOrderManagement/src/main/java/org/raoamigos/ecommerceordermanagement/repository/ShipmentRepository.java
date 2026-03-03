package org.raoamigos.ecommerceordermanagement.repository;

import org.raoamigos.ecommerceordermanagement.entity.Shipment;
import org.raoamigos.ecommerceordermanagement.entity.Warehouse;
import org.raoamigos.ecommerceordermanagement.enums.ShipmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

    Shipment findByTrackingNumber(String trackingNumber);
    List<Shipment> findByCustomerEmail(String customerEmail);
    List<Shipment> findByStatus(ShipmentStatus status);
    List<Shipment> findByWarehouse(Warehouse warehouse);
}
