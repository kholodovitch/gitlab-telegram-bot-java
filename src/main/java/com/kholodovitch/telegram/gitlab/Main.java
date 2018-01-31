package com.kholodovitch.telegram.gitlab;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;
import org.telegram.telegrambots.logging.BotsFileHandler;

import com.kholodovitch.telegram.gitlab.handlers.MainHandlers;

public class Main {
	private static final String LOGTAG = "MAIN";

	public static void main(String[] args) {
		BotLogger.setLevel(Level.ALL);
		BotLogger.registerLogger(new ConsoleHandler());

		try {
			BotLogger.registerLogger(new BotsFileHandler());
		} catch (IOException e) {
			BotLogger.severe(LOGTAG, e);
		}

		try {
			ApiContextInitializer.init();
			TelegramBotsApi telegramBotsApi = createTelegramBotsApi();

			try {
				telegramBotsApi.registerBot(new MainHandlers());
			} catch (Throwable e) {
				BotLogger.error(LOGTAG, e);
			}
		} catch (Exception e) {
			BotLogger.error(LOGTAG, e);
		}
	}

	private static TelegramBotsApi createTelegramBotsApi() throws TelegramApiException {
		return new TelegramBotsApi();
	}
}
