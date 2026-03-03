package org.raoamigos.ecommerceordermanagement.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipmentRequestDTO {

    private String trackingNumber;
    private String customerEmail;
    private Long warehouseId;
}
