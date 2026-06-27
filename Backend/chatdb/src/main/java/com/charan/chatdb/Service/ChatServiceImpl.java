package com.charan.chatdb.Service;

import java.time.LocalDateTime;
import java.util.*;
import org.springframework.stereotype.Service;

import com.charan.chatdb.DTO.*;
import com.charan.chatdb.Model.*;
import com.charan.chatdb.Repository.*;

import jakarta.transaction.Transactional;

@Service
public class ChatServiceImpl implements ChatService {
    AiServiceImpl aiService;
    SqlServiceImpl sqlService;
    ChatHistoryRepository chatHistoryRepository;
    UserRepository userRepository;
    public ChatServiceImpl( AiServiceImpl aiService,SqlServiceImpl sqlService,ChatHistoryRepository chatHistoryRepository,UserRepository userRepository){
        this.aiService = aiService;
        this.sqlService = sqlService;
        this.chatHistoryRepository = chatHistoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ChatResponse processChat(ChatRequest request) {
        
        String prompt = buildPrompt(request.getQuestion());

        String query = aiService.generateSql(prompt);

        QueryResultResponse rows = sqlService.executeSql(query);

        ChatResponse response = new ChatResponse();
        response.setQuestion(request.getQuestion());
        response.setGeneratedSql(query);
        response.setQueryResult(rows);

        ChatHistory obj = new ChatHistory();
        User user = userRepository.findById(request.getUserId()).orElse(null);
        obj.setUser(user);
        obj.setQuestion(request.getQuestion());
        obj.setGeneratedSql(query);
        obj.setAiResponse("");
        obj.setExecutionTime((long)0);
        obj.setCreatedAt(LocalDateTime.now());
        obj.setRowsReturned(rows.getRowCount());
        chatHistoryRepository.save(obj);
        System.out.println(user);
        return response;

    }

    @Override
    public List<ChatHistoryDto> getChatHistory(Long id) {
        List<ChatHistory> temp = chatHistoryRepository.findByUserId(id);
        List<ChatHistoryDto> response = new ArrayList<>();
        for(ChatHistory ele:temp) response.add(convertToChatHistoryDto(ele));
        return response;
    }

    @Override
    public ChatHistoryDto getChatById(Long id) {
        ChatHistory temp = chatHistoryRepository.findById(id).orElse(null);
        if(temp==null){
            throw new RuntimeException();
        }
        ChatHistoryDto obj = convertToChatHistoryDto(temp);
        return obj;
    }

    @Override
    public void deleteChatById(Long id) {
        chatHistoryRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAllChats(Long id) {
        chatHistoryRepository.deleteAllByUserId(id);
    }

    private String buildPrompt(String question) {

    return """
            You are an expert MySQL developer.

            Convert the user's question into a valid MySQL SELECT query.

            Database Name:
            chatdb

            Database Schema:

            employee(
                id INT PRIMARY KEY AUTO_INCREMENT,
                name VARCHAR(100),
                department VARCHAR(50),
                designation VARCHAR(50),
                salary DECIMAL(10,2),
                age INT,
                city VARCHAR(50),
                joining_date DATE
            )

            Rules:
            1. Generate ONLY valid MySQL SELECT statements.
            2. Return ONLY the SQL query.
            3. Do NOT include explanations.
            4. Do NOT use markdown or ```sql.
            5. Never generate INSERT, UPDATE, DELETE, DROP, ALTER, CREATE or TRUNCATE statements.
            6. Use only the tables and columns provided in the schema above.
            7. If the question cannot be answered using the given schema, return exactly:
               INVALID_QUERY

            User Question:
            %s
            """.formatted(question);
    }
    
    private ChatHistoryDto convertToChatHistoryDto(ChatHistory chatHistory){
        ChatHistoryDto obj = new ChatHistoryDto();
        obj.setId(chatHistory.getId());
        obj.setCreatedAt(chatHistory.getCreatedAt());
        obj.setExecutionTime(chatHistory.getExecutionTime());
        obj.setGeneratedSql(chatHistory.getGeneratedSql());
        obj.setQuestion(chatHistory.getQuestion());
        obj.setRowsReturned(chatHistory.getRowsReturned());

        return obj;
    }
}
