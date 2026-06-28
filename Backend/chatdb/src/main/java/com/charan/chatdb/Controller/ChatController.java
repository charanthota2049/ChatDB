package com.charan.chatdb.Controller;

import com.charan.chatdb.DTO.*;
import com.charan.chatdb.Service.ChatServiceImpl;

import org.springframework.web.bind.annotation.*;
import java.util.*;

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
    public List<ChatHistoryDto> getChatHistory(@RequestBody IdRequest request){
        // System.out.println(obj);
        return chatService.getChatHistory(request.getId());
    }

    @GetMapping("/history/id/{id}")
    public ChatHistoryDto getChatById(@PathVariable Long id){
        return chatService.getChatById(id);
    }

    @DeleteMapping("/history/id/{id}")
    public void deleteChatById(@PathVariable Long id){
        chatService.deleteChatById(id);
    }

    @DeleteMapping("/history")
    public void deleteAllChats(@RequestBody IdRequest request){
        chatService.deleteAllChats(request.getId());
    }

    // @PostMapping("/chat/regenerate")
    // public void regenerateSql(){

    // }

    // @PostMapping("/chat/explain")
    // public void explainSql(){

    // }

    // @PostMapping("/chat/Execute")
    // public void executeSql(){

    // }

    // @GetMapping("/schema")
    // public void getDatabaseSchema(){

    // }

    // @GetMapping("/schema/name/{tableName}")
    // public void getTableSchema(){
        
    // }

}
