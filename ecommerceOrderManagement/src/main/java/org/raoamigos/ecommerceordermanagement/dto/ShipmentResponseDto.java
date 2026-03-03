package org.raoamigos.ecommerceordermanagement.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipmentResponseDto {

    private Long id;
    private String trackingNumber;
    private String status;
    private String customerEmail;
    private String warehouseName;
}
