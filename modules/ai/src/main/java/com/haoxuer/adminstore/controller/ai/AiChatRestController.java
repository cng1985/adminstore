package com.haoxuer.adminstore.controller.ai;

import com.haoxuer.adminstore.ai.service.AiChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/ai")
public class AiChatRestController {

    @Autowired
    private AiChatService aiChatService;

    /**
     * 简单对话接口，供后台或其它客户端调用。
     * 示例：GET /web/rest/ai/chat.json?message=你好
     */
    @RequestMapping("/chat")
    public AiChatJsonResponse chat(@RequestParam("message") String message) {
        String reply = aiChatService.chat(message);
        return new AiChatJsonResponse(reply);
    }

    public static final class AiChatJsonResponse {
        private final String reply;

        public AiChatJsonResponse(String reply) {
            this.reply = reply;
        }

        public String getReply() {
            return reply;
        }
    }
}
