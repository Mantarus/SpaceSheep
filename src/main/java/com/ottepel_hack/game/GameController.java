package com.ottepel_hack.game;

import com.ottepel_hack.controllers.SolutionResponseBody;
import com.ottepel_hack.managers.ActionSequence;
import com.ottepel_hack.managers.JavaScriptTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.script.ScriptException;
import java.util.List;

/**
 * Created by iistomin on 18/03/17.
 */
@Component
@Scope(value = "prototype")
public class GameController {

    @Autowired
    private LevelManager levelManager;

    @Autowired
    private JavaScriptTranslator javaScriptTranslator;

    public LevelState startSimpleLevel() {
        return levelManager.getNewLevel();
    }

    public ActionSequence executeScript(String script) throws ScriptException {

        javaScriptTranslator.execute(script);
        return new ActionSequence();
    }

}
