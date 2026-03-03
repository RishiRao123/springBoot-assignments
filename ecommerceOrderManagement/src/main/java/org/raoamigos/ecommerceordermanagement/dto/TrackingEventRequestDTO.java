package org.raoamigos.ecommerceordermanagement.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrackingEventRequestDTO {

    private String eventType;
    private String location;
    private Long shipmentId;
}
