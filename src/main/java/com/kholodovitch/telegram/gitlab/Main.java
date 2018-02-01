package com.kholodovitch.telegram.gitlab;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

import org.apache.http.impl.bootstrap.HttpServer;
import org.apache.http.impl.bootstrap.ServerBootstrap;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;
import org.telegram.telegrambots.logging.BotsFileHandler;

import com.kholodovitch.telegram.gitlab.handlers.HttpHandler;
import com.kholodovitch.telegram.gitlab.handlers.MainHandlers;

public class Main {
	private static final String LOGTAG = "MAIN";

	public static void main(String[] args) throws IOException {
		initLogger();

		MainHandlers bot = null;
		try {
			ApiContextInitializer.init();
			TelegramBotsApi telegramBotsApi = createTelegramBotsApi();

			try {
				bot = new MainHandlers();
				telegramBotsApi.registerBot(bot);
			} catch (Throwable e) {
				BotLogger.error(LOGTAG, e);
			}
		} catch (Exception e) {
			BotLogger.error(LOGTAG, e);
		}
		
		HttpServer server = ServerBootstrap.bootstrap()
				.setListenerPort(8765)
				.registerHandler("/", new HttpHandler(bot))
				.create();
		server.start();
	}

	private static void initLogger() {
		BotLogger.setLevel(Level.ALL);
		BotLogger.registerLogger(new ConsoleHandler());

		try {
			BotLogger.registerLogger(new BotsFileHandler());
		} catch (IOException e) {
			BotLogger.severe(LOGTAG, e);
		}
	}

	private static TelegramBotsApi createTelegramBotsApi() throws TelegramApiException {
		return new TelegramBotsApi();
	}
}
