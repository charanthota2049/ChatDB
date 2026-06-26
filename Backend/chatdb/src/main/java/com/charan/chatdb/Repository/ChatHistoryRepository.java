package com.charan.chatdb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.charan.chatdb.Model.ChatHistory;

@Repository
public interface ChatHistoryRepository extends JpaRepository<ChatHistory,Long> {
    
}
