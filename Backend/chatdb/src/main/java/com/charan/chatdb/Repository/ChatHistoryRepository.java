package com.charan.chatdb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charan.chatdb.Model.ChatHistory;
import java.util.*;


public interface ChatHistoryRepository extends JpaRepository<ChatHistory,Long> {
    // @Query(value="SELECT * FROM CHAT_HISTORY WHERE user_id = :id",nativeQuery = true)
    // List<ChatHistory> findAllByUserId(Long id);

    List<ChatHistory> findByUserId(Long id);

    void deleteAllByUserId(long id);
}
