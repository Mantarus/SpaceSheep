package com.ottepel_hack.managers;

import com.ottepel_hack.controllers.SolutionResponseBody;
import com.ottepel_hack.game.LevelState;

import javax.script.ScriptException;

/**
 * Created by iistomin on 18/03/17.
 */
public interface SolutionManager {

    public ActionSequence testSolution(String javascript) throws ScriptException;

    public SolutionResponseBody testSolution(LevelState levelState, String javascript) throws ScriptException;

}
