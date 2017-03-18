package com.ottepel_hack.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.script.ScriptException;

/**
 * Created by iistomin on 18/03/17.
 */
@Component
public class SolutionManagerImpl implements SolutionManager {

    @Autowired
    private JsonTranslator jsonTranslator;

    @Override
    public Object testSolution(String javascript) throws ScriptException {
        return jsonTranslator.execute(javascript);
    }
}
