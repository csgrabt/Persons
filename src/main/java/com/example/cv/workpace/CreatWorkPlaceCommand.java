package com.example.cv.workpace;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatWorkPlaceCommand {
    private String nameOfTheCompany;
    private Integer startingYear;
    private Integer finishYear;
}
