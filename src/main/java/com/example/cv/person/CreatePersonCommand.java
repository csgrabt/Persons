package com.example.cv.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonCommand {

    private String name;
    private Integer yearOfBirth;

}
