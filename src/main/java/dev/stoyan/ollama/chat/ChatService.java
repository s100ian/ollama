package dev.stoyan.ollama.chat;

import dev.stoyan.ollama.person.PersonService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private static final String SYSTEM_MESSAGE = "If you cannot give an answer or you don't know the answer, type 'I don't know'. Use only provided tool methods and do not hallucinate new ones.";
    private final ChatClient chatClient;
    private final PersonService personService;

    public ChatService(final ChatClient.Builder builder, final PersonService personService) {
        this.chatClient = builder.build();
        this.personService = personService;
    }

    public String chat(final String message) {
        return chatClient.prompt().system(SYSTEM_MESSAGE).user(message).tools(personService).call().content();
    }
}
