package com.example.cv.person;

import com.example.cv.address.UpdateAddressCommand;
import com.example.cv.contact.UpdateContactCommand;
import com.example.cv.education.CreateEducationCommand;
import com.example.cv.workpace.CreatWorkPlaceCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/persons")
@RestController
@AllArgsConstructor
@Tag(name = "Operation with Persons")
public class PersonController {

    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Creates a Person")
    @ApiResponse(responseCode = "201", description = "Person has been created")
    public PersonDTO createPerson(@RequestBody CreatePersonCommand command) {
        return personService.createPerson(command);
    }

    @GetMapping
    @Operation(summary = "Give back the all person from the database")
    public List<PersonDTO> getPersonsFromDb() {
        return personService.getAllPersonFromDb();
    }

    @GetMapping("/{id}")
    public PersonDTO findPersonBasedOnID(@PathVariable("id") Long id) {
        return personService.findPersonBasedOnId(id);
    }

    @PutMapping("/{id}/contacts")
    public PersonDTO updatePersonEmailOrMobileNumber(@PathVariable("id") Long id, @RequestBody UpdateContactCommand command) {
        return personService.updatePersonEmailOrMobileNumber(id, command);
    }

    @PutMapping("/{id}/contacts/address")
    public PersonDTO updatePersonAddress(@PathVariable("id") Long id, @RequestBody UpdateAddressCommand command) {
        return personService.updatePersonAddress(id, command);
    }

    @PostMapping("/{id}/educations")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDTO addEducationToPerson(@PathVariable("id") Long id, @RequestBody CreateEducationCommand command) {
        return personService.addEducation(id, command);
    }

    @PostMapping("/{id}/workplace")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDTO addWorkPlaceToPerson(@PathVariable("id") Long id, @RequestBody CreatWorkPlaceCommand command) {
        return personService.addWorkPlace(id, command);
    }

}
