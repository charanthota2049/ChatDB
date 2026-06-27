package com.charan.chatdb.Service;

import com.charan.chatdb.DTO.*;
import java.util.*;



public interface ChatService{
    ChatResponse processChat(ChatRequest request);
    List<ChatHistoryDto> getChatHistory(Long id);
    ChatHistoryDto getChatById(Long id);
    void deleteChatById(Long id);
    void deleteAllChats(Long id);
}
    