package org.raoamigos.ecommerceordermanagement.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrackingEventResponseDTO {

    private Long id;
    private String eventType;
    private String location;
    private Long shipmentId;
    private String timestamp;
}
