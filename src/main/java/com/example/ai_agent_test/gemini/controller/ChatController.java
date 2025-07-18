package com.example.ai_agent_test.gemini.controller;



import java.io.IOException;
import java.util.Map;
import java.util.function.Function;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ai_agent_test.gemini.tools.DateTimeTools;

@RestController
public class ChatController {

	private final ChatClient chatClient;
	
	public ChatController(ChatClient.Builder chatClientBuilder) {
		this.chatClient = chatClientBuilder
						.build();
	}
	
	/**
	 * 텍스트 기반 질문-응답 API 엔드 포인트
	 * @param message 질문 텍스트
	 * @return Gemini 모델 응답 텍스트
	 */
	@PostMapping("/chat/text")
	public String chat(@RequestBody String message) {
		return chatClient.prompt()
						.user(message)
						.tools(new DateTimeTools())
						.call()
						.content();
	}
	
	/**
	 * 이미지 질문
	 * @param imageFile 이미지
	 * @param query 질문 텍스트
	 * @return
	 * @throws IOException
	 */
	@PostMapping(value = "/chat/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String chatWithBinaryImage(@RequestParam("image") MultipartFile imageFile, 
            @RequestParam("query") String query) throws IOException {
		// 바이너리 이미지 데이터를 Media 객체로 변환
		byte[] data = imageFile.getBytes(); 
		Resource imageResource = new ByteArrayResource(data);
		
		Map<String, Object> options = Map.of("languageCode", "ko-KR");
        return chatClient.prompt().user(u -> u.text(query + "key값을 인물이면 person, 사물이면 thing, 장소면 place로 응답(그 외 내용설명 포함)")
        							.media(MimeTypeUtils.IMAGE_PNG, imageResource)).call().content();
	}
}
