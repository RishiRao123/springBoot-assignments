package org.raoamigos.ecommerceordermanagement.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseRequestDTO {

    private String name;
    private String location;
    private int capacity;
}
