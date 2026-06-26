package com.charan.chatdb.Model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class ChatHistory {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String question;
    @Column(columnDefinition = "TEXT")
    private String generatedSql;
    @Column(columnDefinition = "TEXT")
    private String aiResponse;
    private Long executionTime;
    private LocalDateTime createdAt;
    private Integer rowsReturned;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getGeneratedSql() {
        return generatedSql;
    }

    public String getAiResponse() {
        return aiResponse;
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Integer getRowsReturned() {
        return rowsReturned;
    }

    public User getUser() {
        return user;
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

    public void setAiResponse(String aiResponse) {
        this.aiResponse = aiResponse;
    }

    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setRowsReturned(Integer rowsReturned) {
        this.rowsReturned = rowsReturned;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
}
