package com.charan.chatdb.Service;

import org.springframework.stereotype.Service;

import com.charan.chatdb.DTO.*;

@Service
public interface SqlService {

    QueryResultResponse executeSql(String sql);
    
    boolean isSafeQuery(String sql);
}
