package org.raoamigos.ecommerceordermanagement.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseResponseDTO {

    private Long id;
    private String name;
    private String location;
    private int capacity;
}
