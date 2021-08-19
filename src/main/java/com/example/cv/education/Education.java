package com.example.cv.education;

import com.example.cv.person.Person;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "educations")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String major;
    private Integer yearOfFinished;
    @ManyToOne()
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Person person;


    public Education(String major, Integer yearOfFinished) {
        this.major = major;
        this.yearOfFinished = yearOfFinished;
    }
}

