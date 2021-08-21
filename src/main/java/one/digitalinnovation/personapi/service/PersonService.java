package one.digitalinnovation.personapi.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.mapper.PersonMapper;
import one.digitalinnovation.personapi.repository.PersonRepository;
import one.digitalinnovation.personapi.service.exceptions.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired)) // vantagem de injetar assim é que facilita os testes unitarios
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return createMessageResponse("Created personDTO with ID ", savedPerson.getId());
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream().map(personMapper::toDTO).collect(Collectors.toList());
    }

    public PersonDTO findById(Long idPerson) throws PersonNotFoundException {
        Person personFound = verifyIfExists(idPerson);
        return personMapper.toDTO(personFound);
    }

    public void deleteById(Long idPerson) throws PersonNotFoundException {
        verifyIfExists(idPerson);
        personRepository.deleteById(idPerson);
    }

    public MessageResponseDTO updateById(Long idPerson, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(idPerson);
        Person personToUpdate = personMapper.toModel(personDTO);
        Person updatedPerson = personRepository.save(personToUpdate);
        return createMessageResponse("Updated personDTO with ID ", updatedPerson.getId());
    }

    private Person verifyIfExists(Long idPerson) throws PersonNotFoundException {
        return personRepository.findById(idPerson).orElseThrow(() -> new PersonNotFoundException(idPerson));
    }

    private MessageResponseDTO createMessageResponse(String message, Long idPerson) {
        return MessageResponseDTO.builder().message(message + idPerson).build();
    }
}
