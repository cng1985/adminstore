package com.haoxuer.adminstore.ai.service;

import dev.langchain4j.model.chat.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AiChatService {

    @Autowired
    private ChatModel chatModel;

    public String chat(String message) {
        if (message == null || message.isBlank()) {
            return "请输入非空的 message。";
        }
        return chatModel.chat(message);
    }
}
