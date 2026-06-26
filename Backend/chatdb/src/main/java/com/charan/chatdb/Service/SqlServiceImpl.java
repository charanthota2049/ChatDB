package com.charan.chatdb.Service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.charan.chatdb.DTO.QueryResultResponse;

import java.util.*;

@Service
public class SqlServiceImpl implements SqlService {

    private final JdbcTemplate jdbcTemplate;
    
    public SqlServiceImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public QueryResultResponse executeSql(String sql) {
        if(!isSafeQuery(sql)){
            return null;
        }
        List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
        QueryResultResponse response = new QueryResultResponse();
        response.setRows(rows);
        response.setRowCount(rows.size());
        return response;
    }

    @Override
    public boolean isSafeQuery(String sql)  {
        if(sql == null || sql.isBlank()){
            throw new IllegalArgumentException("SQL query is empty");
        }

        String query = sql.trim().toUpperCase();

        if(!query.startsWith("SELECT")){
            throw new IllegalArgumentException("only SELECT queries are allowed....");
        }

        return true;
    }
    
}
