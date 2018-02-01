package com.kholodovitch.telegram.gitlab.handlers;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.logging.BotLogger;

import com.kholodovitch.telegram.gitlab.BotConfig;
import com.kholodovitch.telegram.gitlab.hook.model.PipelineHook;

public class MainHandlers extends TelegramLongPollingCommandBot {
	private static final String LOGTAG = "MainHandlers"; 
	
	public MainHandlers() {
		super();
	}

	@Override
	public void processNonCommandUpdate(Update update) {
		System.out.println();
	}

	@Override
	public String getBotUsername() {
		return BotConfig.WEBHOOK_USER;
	}

	@Override
	public String getBotToken() {
		return BotConfig.WEBHOOK_TOKEN;
	}

	public void handle(PipelineHook hook) {
		sendText(hook.getProject().getName() + " : " + hook.getBuilds().get(0).getStatus());
	}

	private void sendText(String text) {
		try {
			SendMessage sendMessage = new SendMessage();
            sendMessage.enableMarkdown(true);
            sendMessage.setChatId(String.valueOf(281120553L));
            sendMessage.setText(text);
			sendMessage(sendMessage);
		} catch (Throwable e) {
			BotLogger.error(LOGTAG, e);
		}
	}
}
