package com.example.cv.person;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(statements = {"delete from cv.persons"})
class PersonControllerRestTemplateIT {
    @Autowired
    TestRestTemplate template;
    @Autowired
    PersonService personService;

    @Test
    void createPerson() {

        PersonDTO personDTO = template.postForObject("/api/persons",
                new CreatePersonCommand(
                        "John Doe", 1951
                ), PersonDTO.class);
        assertEquals(1951, personDTO.getYearOfBirth());

    }


    @Test
    void getPersonFromDb() {
        template.postForObject("/api/persons", new CreatePersonCommand("John Doe", 1951), PersonDTO.class);
        template.postForObject("/api/persons", new CreatePersonCommand("Jack Doe", 1953), PersonDTO.class);
        template.postForObject("/api/persons", new CreatePersonCommand("Jane Doe", 1955), PersonDTO.class);

        List<PersonDTO> list = template.exchange("/api/persons", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<PersonDTO>>() {
                }).getBody();

        assertThat(list)
                .extracting(PersonDTO::getName)
                .containsExactly("John Doe", "Jack Doe", "Jane Doe");
    }

    @Test
    void findPersonBasedOnId() {
        PersonDTO personDTO = template.postForObject("/api/persons", new CreatePersonCommand("John Doe", 1951), PersonDTO.class);
        PersonDTO personDTOFromDB = template.getForObject("/api/persons/" + personDTO.getId(), PersonDTO.class);

        assertEquals(personDTO, personDTOFromDB);

    }

}

