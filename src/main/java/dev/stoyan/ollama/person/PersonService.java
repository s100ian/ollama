package dev.stoyan.ollama.person;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@Slf4j
public class PersonService {
    private static final Collection<PersonDTO> PERSONS = Set.of(
            new PersonDTO("Stoyan", 25, Set.of("Java", "Spring Boot", "meat balls")),
            new PersonDTO("Ollama", 30, Set.of("AI", "machine learning")),
            new PersonDTO("Peter", 35, Set.of("Python", "Django", "Typescript")),
            new PersonDTO("Todor", 40, Set.of("Typescript", "Angular", "React")));

    @Tool(description = "Get the expertise of a person by name")
    public Set<String> getExpertise(final String name) {
        log.info("getExpertise called with name: {}", name);
        return PERSONS.stream().filter(p -> p.name().equals(name)).findFirst().map(PersonDTO::expertise).orElseThrow(() -> new NoSuchElementException("Who? I don't know that person " + name + "."));
    }

    @Tool(description = "Get the age of a person by name")
    public int getAge(final String name) {
        log.info("getAge called with name: {}", name);
        return PERSONS.stream().filter(p -> p.name().equals(name)).findFirst().map(PersonDTO::age).orElseThrow(() -> new NoSuchElementException("Who? I don't know that person " + name + "."));
    }

    @Tool(description = "Get the names of all persons")
    public Collection<String> getPersonNames() {
        log.info("getPersonNames called");
        return PERSONS.stream().map(PersonDTO::name).toList();
    }

}
