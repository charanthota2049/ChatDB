package com.charan.chatdb.DTO;

public class ChatRequest {
    
    private Long userId;

    private String question;

    public Long getUserId() {
        return userId;
    }

    public String getQuestion() {
        return question;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

}
