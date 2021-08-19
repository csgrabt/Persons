package com.example.cv.contact;


import com.example.cv.address.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {
    private Long id;
    private Address address;
    private String mobileNumber;
    private String email;
}
