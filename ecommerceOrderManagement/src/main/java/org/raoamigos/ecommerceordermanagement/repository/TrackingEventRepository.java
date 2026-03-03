package org.raoamigos.ecommerceordermanagement.repository;

import org.raoamigos.ecommerceordermanagement.entity.Shipment;
import org.raoamigos.ecommerceordermanagement.entity.TrackingEvent;
import org.raoamigos.ecommerceordermanagement.enums.TrackingEventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackingEventRepository extends JpaRepository<TrackingEvent, Long> {

    List<TrackingEvent> findByShipment(Shipment shipment);
    List<TrackingEvent> findByEventType(TrackingEventType eventType);
}
