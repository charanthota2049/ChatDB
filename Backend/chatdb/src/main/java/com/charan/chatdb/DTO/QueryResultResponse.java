package com.charan.chatdb.DTO;

import java.util.*;

public class QueryResultResponse {
    private List<Map<String,Object>> rows;
    private Integer rowCount;
    private Long executionTime;
    public List<Map<String, Object>> getRows() {
        return rows;
    }
    public Integer getRowCount() {
        return rowCount;
    }
    public Long getExecutionTime() {
        return executionTime;
    }
    public void setRows(List<Map<String, Object>> rows) {
        this.rows = rows;
    }
    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }
    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }
}
