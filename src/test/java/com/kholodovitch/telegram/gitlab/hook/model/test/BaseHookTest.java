package com.kholodovitch.telegram.gitlab.hook.model.test;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

public abstract class BaseHookTest {

    protected String getJson(String name) throws IOException {
        return IOUtils.toString(getClass().getResourceAsStream(name), Charset.forName("UTF-8"));
    }
    
}
