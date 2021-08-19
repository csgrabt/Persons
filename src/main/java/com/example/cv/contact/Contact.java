package com.example.cv.contact;

import com.example.cv.address.Address;
import com.example.cv.person.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contacts")
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private Address address = new Address();
    private String mobileNumber;
    private String email;



}
