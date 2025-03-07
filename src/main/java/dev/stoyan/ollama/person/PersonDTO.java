package dev.stoyan.ollama.person;

import java.util.Set;

public record PersonDTO(String name, int age, Set<String> expertise) {}
