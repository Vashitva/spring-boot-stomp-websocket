package com.codeecstasy.talker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.codeecstasy.talker.model.ResponseMessage;

@Component
public class MessageGenerator {


    @Autowired
    private SimpMessagingTemplate template;
	
	@Scheduled(fixedDelay = 5000)
	public void sendRandomMessage( ) {
		String randomMessage = "Rand " + System.currentTimeMillis();
		sendMessage(randomMessage);
	}
	
	public void sendMessage(String message) {
		template.convertAndSend("/topic/messages",new ResponseMessage(message));
	}
}
