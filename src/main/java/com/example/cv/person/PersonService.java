package com.example.cv.person;


import com.example.cv.address.Address;
import com.example.cv.address.UpdateAddressCommand;
import com.example.cv.contact.Contact;
import com.example.cv.contact.UpdateContactCommand;
import com.example.cv.education.CreateEducationCommand;
import com.example.cv.education.Education;
import com.example.cv.workpace.CreatWorkPlaceCommand;
import com.example.cv.workpace.WorkPlace;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {
    private PersonRepository personRepository;
    private ModelMapper modelMapper;


    public PersonDTO createPerson(CreatePersonCommand command) {
        Person person = new Person(command.getName(), command.getYearOfBirth());
        personRepository.save(person);
        return modelMapper.map(person, PersonDTO.class);
    }

    public List<PersonDTO> getAllPersonFromDb() {
        return personRepository.findAll()
                .stream()
                .map(n -> modelMapper.map(n, PersonDTO.class))
                .toList();
    }

    public PersonDTO findPersonBasedOnId(Long id) {
        return modelMapper.map(personRepository.findById(id).orElseThrow(), PersonDTO.class);
    }

    @Transactional
    public PersonDTO updatePersonEmailOrMobileNumber(Long id, UpdateContactCommand command) {
        Person person = personRepository.findById(id).orElseThrow();
        if (person.getContactDetails() == null) {
            person.setContactDetails(new Contact());
        }

        if (command.getEmail().isPresent()) {
            person.getContactDetails().setEmail(command.getEmail().get());
        }
        if (command.getMobileNumber().isPresent()) {
            person.getContactDetails().setMobileNumber(command.getMobileNumber().get());
        }

        return modelMapper.map(person, PersonDTO.class);

    }

    @Transactional
    public PersonDTO updatePersonAddress(Long id, UpdateAddressCommand command) {
        Person person = personRepository.findById(id).orElseThrow();
        if (person.getContactDetails() == null) {
            person.setContactDetails(new Contact());
        }

        if (person.getContactDetails().getAddress() == null) {
            person.getContactDetails().setAddress(new Address());
        }
        person.getContactDetails().getAddress().setCity(command.getCity());
        person.getContactDetails().getAddress().setStreet(command.getStreet());
        person.getContactDetails().getAddress().setHouseNumber(command.getHouseNumber());
        person.getContactDetails().getAddress().setZipCode(command.getZipCode());


        return modelMapper.map(person, PersonDTO.class);

    }


    @Transactional
    public PersonDTO addEducation(Long id, CreateEducationCommand command) {
        Person person = personRepository.findById(id).orElseThrow();
        person.addEducation(new Education(command.getMajor(), command.getYearOfFinished()));
        return modelMapper.map(person, PersonDTO.class);
    }

    @Transactional
    public PersonDTO addWorkPlace(Long id, CreatWorkPlaceCommand command) {
        Person person = personRepository.findById(id).orElseThrow();
        person.addWorPlace(new WorkPlace(command.getNameOfTheCompany(), command.getStartingYear(), command.getFinishYear()));
        return modelMapper.map(person, PersonDTO.class);
    }
}

