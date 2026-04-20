package com.haoxuer.adminstore.ai.config;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.request.ChatRequest;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiModelConfiguration {

    @Bean
    public ChatModel chatModel(
            @Value("${OPENAI_API_KEY:}") String apiKey,
            @Value("${OPENAI_MODEL:gpt-4o-mini}") String modelName) {
        if (apiKey == null || apiKey.isBlank()) {
            return new ChatModel() {
                @Override
                public ChatResponse doChat(ChatRequest request) {
                    return ChatResponse.builder()
                            .aiMessage(AiMessage.from(
                                    "未配置 OPENAI_API_KEY，无法调用大模型。请在部署环境或 JVM 系统属性中设置该变量后再试。"))
                            .build();
                }
            };
        }
        return OpenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName(modelName)
                .build();
    }
}
