package com.charan.chatdb.Service;

import com.charan.chatdb.DTO.*;
import java.util.*;

import org.springframework.stereotype.Service;


public interface ChatService{
    ChatResponse processChat(ChatRequest request);
    // List<ChatHistoryDto> getChatHistory();
    // ChatHistoryDto getChatById(Long id);
    // void deleteChatById(Long id);
    // void deleteAllChats();
}
    