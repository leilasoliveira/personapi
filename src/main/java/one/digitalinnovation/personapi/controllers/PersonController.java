package one.digitalinnovation.personapi.controllers;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.service.PersonService;
import one.digitalinnovation.personapi.service.exceptions.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired)) // vantagem de injetar assim é que facilita os testes unitarios
public class PersonController {

    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll() {
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable("id") Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) throws PersonNotFoundException {
        personService.deleteById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updateById(id, personDTO);
    }

}
