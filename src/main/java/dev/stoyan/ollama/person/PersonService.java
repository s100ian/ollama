package dev.stoyan.ollama.person;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Supplier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersonService {

    private static final Collection<PersonDTO> PERSONS = Set.of(
        new PersonDTO("Stoyan", 40, Set.of("Java", "Spring Boot", "Meatballs")),
        new PersonDTO("Slavomir", 30, Set.of("AI", "machine learning")),
        new PersonDTO("Hristo", 35, Set.of("Python", "Django", "Typescript")),
        new PersonDTO("Valentin", 25, Set.of("Typescript", "Angular", "React")));

    private static Supplier<NoSuchElementException> getNoSuchPersonExceptionSupplier(String name) {
        return () -> new NoSuchElementException("Who? I don't know that person " + name + ".");
    }

    @Tool(description = "Return the expertise of a person by name")
    public Set<String> getExpertise(final String name) {
        log.info("getExpertise called with name: {}", name);
        return PERSONS.stream().filter(p -> p.name().equals(name)).findFirst()
            .map(PersonDTO::expertise).orElseThrow(getNoSuchPersonExceptionSupplier(name));
    }

    @Tool(description = "Get the age of a person by name")
    public int getAge(final String name) {
        log.info("getAge called with name: {}", name);
        return PERSONS.stream().filter(p -> p.name().equals(name)).findFirst().map(PersonDTO::age)
            .orElseThrow(getNoSuchPersonExceptionSupplier(name));
    }

    @Tool(description = "Get the names of all persons")
    public Collection<String> getPersonNames() {
        final List<String> names = PERSONS.stream().map(PersonDTO::name).toList();
        log.info("getPersonNames called with result: {}", names);
        return names;
    }

}
