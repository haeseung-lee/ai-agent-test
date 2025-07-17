//package com.example.ai_agent_test.config;
//
//import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class GeminiConfig {
//    @Value("${spring.ai.vertex.ai.gemini.api-key}")
//    private String apiKey;
//
//    @Value("${spring.ai.vertex.ai.gemini.project-id}")
//    private String projectId;
//
//    @Bean
//    public ChatClient chatClient() {
//
//    	System.out.println("api Key : " + apiKey);
//    	System.out.println("projectId : " + projectId);
//            return null;
//
//    }
//	
//}
