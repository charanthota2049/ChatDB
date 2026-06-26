package com.charan.chatdb.Controller;

import com.charan.chatdb.DTO.*;
import com.charan.chatdb.Service.ChatServiceImpl;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class ChatController {
    private ChatServiceImpl chatService;

    public ChatController(ChatServiceImpl chatService){
        this.chatService = chatService;
    }

    @PostMapping("/chat")
    public ChatResponse processChat(@RequestBody ChatRequest request) {
        return chatService.processChat(request);
    }

    @GetMapping("/history")
    public void getChatHistory(){

    }

    @GetMapping("/history/id/{id}")
    public void getChatById(){

    }

    @DeleteMapping("/history/id/{id}")
    public void deleteChatById(){

    }

    @DeleteMapping("/history")
    public void deleteAllChats(){

    }

    @PostMapping("/chat/regenerate")
    public void regenerateSql(){

    }

    @PostMapping("/chat/explain")
    public void explainSql(){

    }

    @PostMapping("/chat/Execute")
    public void executeSql(){

    }

    @GetMapping("/schema")
    public void getDatabaseSchema(){

    }

    @GetMapping("/schema/name/{tableName}")
    public void getTableSchema(){
        
    }

}
