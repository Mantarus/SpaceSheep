package com.ottepel_hack.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by iistomin on 18/03/17.
 */
@Component
@Scope(value = "prototype")
public class JavaScriptTranslator {

    @Autowired
    private ScriptEngine scriptEngine;

    private FileReader fileReader;

    @PostConstruct
    public void loadResources() throws IOException, ScriptException {
        fileReader = new FileReader(new ClassPathResource("js_scripts/predefined_functions.js").getFile());
        scriptEngine.eval(fileReader);
    }

    public Object execute(String javascript) throws ScriptException {
        return scriptEngine.eval(javascript);
    }

}
