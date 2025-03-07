package dev.stoyan.ollama;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class PersonService {
    @Tool(description = "Get the expertise of a person by name")
    public String getExpertise(final String name) {
        return switch (name) {
            case "Stoyan" -> "Java, Spring Boot, meat balls";
            case "Ollama" -> "AI, machine learning";
            default -> throw new NoSuchElementException("Who? I don't know that person.");
        };
    }

    @Tool(description = "Get the age of a person by name")
    public int getAge(final String name) {
        return switch (name) {
            case "Stoyan" -> 25; // :)
            case "Ollama" -> 30;
            default -> throw new NoSuchElementException("Who? I don't know that person.");
        };
    }

    @Tool(description = "Get the names of all persons")
    public Collection<String> getPersonNames() {
        return Set.of("Stoyan", "Ollama");
    }
}
