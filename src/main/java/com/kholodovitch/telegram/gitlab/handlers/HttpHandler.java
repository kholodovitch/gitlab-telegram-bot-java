package com.kholodovitch.telegram.gitlab.handlers;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;
import org.apache.http.util.EntityUtils;
import org.telegram.telegrambots.logging.BotLogger;

import com.kholodovitch.telegram.gitlab.JacksonConfig;
import com.kholodovitch.telegram.gitlab.hook.model.PipelineHook;

public class HttpHandler implements HttpRequestHandler {

	private static final String LOGTAG = "HttpHandler";
	private MainHandlers bot;

	public HttpHandler(MainHandlers bot) {
		this.bot = bot;
	}

	@Override
	public void handle(HttpRequest request, HttpResponse response, HttpContext context) throws HttpException, IOException {
		if (!(request instanceof HttpEntityEnclosingRequest))
			return;

		try {
			HttpEntity entity = ((HttpEntityEnclosingRequest) request).getEntity();
			String body = EntityUtils.toString(entity);
			PipelineHook hook = JacksonConfig.getObjectMapper().readValue(body, PipelineHook.class);
			bot.handle(hook);
		} catch (Exception e) {
			BotLogger.severe(LOGTAG, e);
		}
	}

}
