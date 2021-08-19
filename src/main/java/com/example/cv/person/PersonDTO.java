package com.example.cv.person;

import com.example.cv.address.AddressDTO;
import com.example.cv.contact.ContactDTO;
import com.example.cv.education.Education;
import com.example.cv.education.EducationDTO;
import com.example.cv.workpace.WorkPlaceDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    private Long id;
    private String name;
    private Integer yearOfBirth;
    private ContactDTO contact;
    private List<WorkPlaceDTO> workHistory;
    private List<EducationDTO> educations;
}
