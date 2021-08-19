package com.example.cv.workpace;

import com.example.cv.person.Person;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "workplaces")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameOfTheCompany;
    private Integer startingYear;
    private Integer finishYear;
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Person person;

    public WorkPlace(String nameOfTheCompany, Integer startingYear, Integer finishYear) {
        this.nameOfTheCompany = nameOfTheCompany;
        this.startingYear = startingYear;
        this.finishYear = finishYear;
    }
}
