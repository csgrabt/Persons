package com.example.cv.person;

import com.example.cv.contact.Contact;
import com.example.cv.education.Education;
import com.example.cv.education.EducationDTO;
import com.example.cv.workpace.WorkPlace;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer yearOfBirth;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Contact contactDetails;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "person")
    private List<WorkPlace> workHistory;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "person")
    private List<Education> educations;

    public Person(String name, Integer yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public void addEducation(Education education) {
        if (educations == null) {
            educations = new ArrayList<>();
        }
        educations.add(education);
        education.setPerson(this);
    }

    public void addWorPlace(WorkPlace workPlace) {
        if (workHistory == null) {
            workHistory = new ArrayList<>();
        }
        workHistory.add(workPlace);
        workPlace.setPerson(this);
    }

}
