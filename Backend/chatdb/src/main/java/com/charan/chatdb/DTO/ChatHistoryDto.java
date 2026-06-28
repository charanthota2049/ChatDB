package com.charan.chatdb.DTO;

import java.time.LocalDateTime;

public class ChatHistoryDto {
    
    private Long id;

    private String question;

    private String generatedSql;

    // private String aiResponse;

    private Long executionTime;

    private Integer rowsReturned;

    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getGeneratedSql() {
        return generatedSql;
    }

    // public String getAiResponse() {
    //     return aiResponse;
    // }

    public Long getExecutionTime() {
        return executionTime;
    }

    public Integer getRowsReturned() {
        return rowsReturned;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setGeneratedSql(String generatedSql) {
        this.generatedSql = generatedSql;
    }

    // public void setAiResponse(String aiResponse) {
    //     this.aiResponse = aiResponse;
    // }

    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public void setRowsReturned(Integer rowsReturned) {
        this.rowsReturned = rowsReturned;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    

}
