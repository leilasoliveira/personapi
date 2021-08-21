package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.entity.Person;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;

public class PersonUtils {

    private static final String FIRST_NAME = "Leila";
    private static final String LAST_NAME = "Farias";
    private static final String CPF = "406.324.679-80";
    private static final String BIRTH_DATE = "09-12-1978";
    private static final LocalDate BIRTH_DATE_LOCAL_DATE = LocalDate.of(1978, Month.DECEMBER, 9);
    private static final Long PERSON_ID = 1L;

    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF)
                .birthDate(BIRTH_DATE_LOCAL_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }

}
