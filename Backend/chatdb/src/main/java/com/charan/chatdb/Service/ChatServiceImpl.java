package com.charan.chatdb.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.charan.chatdb.DTO.*;
import com.charan.chatdb.Model.ChatHistory;
import com.charan.chatdb.Repository.*;

@Service
public class ChatServiceImpl implements ChatService {
    AiServiceImpl aiService;
    SqlServiceImpl sqlService;
    ChatHistoryRepository chatHistoryRepository;

    public ChatServiceImpl( AiServiceImpl aiService,SqlServiceImpl sqlService,ChatHistoryRepository chatHistoryRepository){
        this.aiService = aiService;
        this.sqlService = sqlService;
        this.chatHistoryRepository = chatHistoryRepository;
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
        obj.setQuestion(request.getQuestion());
        obj.setGeneratedSql(query);
        obj.setAiResponse("");
        obj.setExecutionTime((long)0);
        obj.setCreatedAt(LocalDateTime.now());
        obj.setRowsReturned(rows.getRowCount());
        chatHistoryRepository.save(obj);
        return response;

    }

    // @Override
    // public List<ChatHistoryDto> getChatHistory() {
    // }

    // @Override
    // public ChatHistoryDto getChatById(Long id) {
    // }

    // @Override
    // public void deleteChatById(Long id) {
    // }

    // @Override
    // public void deleteAllChats() {
    // }

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
    
}
