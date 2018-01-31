package com.kholodovitch.telegram.gitlab.handlers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingCommandBot;

import com.kholodovitch.telegram.gitlab.BotConfig;

public class MainHandlers extends TelegramLongPollingCommandBot implements Runnable {
    private static final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1); 
	
	public MainHandlers() {
		super();
        startAlertTimers();
	}

	private void startAlertTimers() {
        executorService.scheduleWithFixedDelay(this, 1, 12, TimeUnit.SECONDS);
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

	@Override
	public void run() {
		try {
			SendMessage sendMessage = new SendMessage();
            sendMessage.enableMarkdown(true);
            sendMessage.setChatId(String.valueOf(281120553L));
            sendMessage.setText("123");
			sendMessage(sendMessage);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
