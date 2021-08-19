package com.example.cv.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateContactCommand {
    private Optional<String> mobileNumber;
    private Optional<String> email;
}
