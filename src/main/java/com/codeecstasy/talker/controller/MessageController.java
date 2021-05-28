package com.codeecstasy.talker.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.codeecstasy.talker.model.Message;
import com.codeecstasy.talker.model.ResponseMessage;

@Controller
public class MessageController {

	@MessageMapping("/messages")
	@SendTo("/topic/messages")
	public ResponseMessage getMessage(final Message message) {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println("Message "+ message);
		return new ResponseMessage(HtmlUtils.htmlEscape(message.getMessageContent()));
	}
	
}
