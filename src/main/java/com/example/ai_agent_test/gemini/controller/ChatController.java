package com.example.ai_agent_test.gemini.controller;



import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.net.HttpHeaders;

@RestController
public class ChatController {

	private final ChatClient chatClient;
	
	public ChatController(ChatClient.Builder chatClientBuilder) {
		this.chatClient = chatClientBuilder.build();
	}
	
	/**
	 * 텍스트 기반 질문-응답 API 엔드 포인트
	 * @param message 질문 텍스트
	 * @return Gemini 모델 응답 텍스트
	 */
	@GetMapping("/chat/text")
	public String chat(@RequestParam String message) {
		return chatClient.prompt()
						.user(message)
						.call()
						.content();
	}
	
//	@PostMapping(value = "/chat/image-binary", consumes = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE})
//	public String chatWithBinaryImage(
//			@RequestBody byte[] imageBytes,
//			@RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType,
//			@RequestParam String promptText 
//			) {
//		
//		//바이너리 데이터를 Spring resource 로 변환
//		ByteArrayResource imageResouce = new ByteArrayResource(imageBytes);
//		
//		//Content-Type 헤더를 기반으로 MediaType을 파싱
//		MediaType mediaType = MediaType.parseMediaType(contentType);
//		
//		//Media 객체 생성
//		Media media = new MediaType(mediaType, imageResouce)''
//		
//	}

}
