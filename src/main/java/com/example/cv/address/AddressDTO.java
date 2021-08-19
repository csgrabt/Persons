package com.example.cv.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressDTO {
    private Long id;
    private String zipCode;
    private String city;
    private String street;
    private String houseNumber;
}
