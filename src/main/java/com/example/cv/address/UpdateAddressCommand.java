package com.example.cv.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAddressCommand {
    private String zipCode;
    private String city;
    private String street;
    private String houseNumber;
}
