package com.ottepel_hack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Created by iistomin on 18/03/17.
 */
@Configuration
public class JSConfig {

    @Bean
    ScriptEngine scriptEngine() {
        return new ScriptEngineManager().getEngineByName("nashorn");
    }

}
