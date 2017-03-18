package com.ottepel_hack.game;

import com.ottepel_hack.controllers.SolutionResponseBody;
import com.ottepel_hack.managers.ActionSequence;
import com.ottepel_hack.managers.JavaScriptTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.script.ScriptException;
import java.util.List;

/**
 * Created by iistomin on 18/03/17.
 */
@Component
public class GameController {

    @Autowired
    private LevelStateFactory levelStateFactory;

    @Autowired
    private JavaScriptTranslator javaScriptTranslator;

    public LevelState startSimpleLevel() {
        return levelStateFactory.getSimpleLevel();
    }

    public SolutionResponseBody executeScript(String script, LevelState levelState) throws ScriptException {
        javaScriptTranslator.execute(script);
        ActionSequence sequence = new ActionSequence((List<String>)javaScriptTranslator.execute("result"));
        return new SolutionResponseBody(levelState, sequence);
    }

}
