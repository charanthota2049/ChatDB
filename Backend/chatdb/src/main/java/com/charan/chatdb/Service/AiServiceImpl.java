package com.charan.chatdb.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.*;
import org.springframework.web.client.RestClient;


import com.charan.chatdb.DTO.gemini.*;

@Service
public class AiServiceImpl implements AiService {

    private final RestClient restClient;

    @Value("${gemini.api.key}")
    private String apiKey;

    private static final String GEMINI_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent";
    
    public AiServiceImpl(RestClient restClient){
        this.restClient = restClient;
    }

    @Override
    public String generateSql(String prompt) {
        GeminiRequest request = new GeminiRequest(
                                    List.of(
                                        new Content(
                                            List.of(
                                                new Part(prompt)
                                            )
                                        )
                                    )
                                );
        GeminiResponse response = restClient.post()
                            .uri(GEMINI_URL+"?key="+apiKey)
                            .body(request)
                            .retrieve()
                            .body(GeminiResponse.class);
        return cleanSql(response.getCandidates().getFirst().getContent().getParts().getFirst().getText());
    }
    
    private String cleanSql(String sql){
        return sql.replace("```sql", "")
                    .replace("```", "")
                    .trim();
    }
}
