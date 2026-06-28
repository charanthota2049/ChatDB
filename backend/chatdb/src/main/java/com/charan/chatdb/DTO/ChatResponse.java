package com.charan.chatdb.DTO;

public class ChatResponse {
     
    private String question;

    private String generatedSql;

    // private String aiResponse;

   private QueryResultResponse queryResult;

   public String getQuestion() {
    return question;
   }

   public String getGeneratedSql() {
    return generatedSql;
   }

//    public String getAiResponse() {
//     return aiResponse;
//    }

   public QueryResultResponse getQueryResult() {
    return queryResult;
   }

   public void setQuestion(String question) {
    this.question = question;
   }

   public void setGeneratedSql(String generatedSql) {
    this.generatedSql = generatedSql;
   }

//    public void setAiResponse(String aiResponse) {
//     this.aiResponse = aiResponse;
//    }

   public void setQueryResult(QueryResultResponse queryResult) {
    this.queryResult = queryResult;
   }

}
