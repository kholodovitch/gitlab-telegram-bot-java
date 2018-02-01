package com.kholodovitch.telegram.gitlab.hook.model.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.kholodovitch.telegram.gitlab.JacksonConfig;
import com.kholodovitch.telegram.gitlab.hook.model.PipelineHook;

class PipelineHookTest extends BaseHookTest {

	@Test
	void testDecoding() throws Exception {
		PipelineHook object = JacksonConfig
				.getObjectMapper()
				.readValue(getJson("PipelineEvent.json"), PipelineHook.class);

		assertNotNull(object);
	}

}
