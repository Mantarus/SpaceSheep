package com.ottepel_hack.managers;

import com.ottepel_hack.controllers.SolutionResponseBody;
import com.ottepel_hack.game.GameController;
import com.ottepel_hack.game.LevelManager;
import com.ottepel_hack.game.LevelState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.script.ScriptException;
import java.util.ArrayList;

/**
 * Created by iistomin on 18/03/17.
 */
@Component
public class SolutionManagerImpl implements SolutionManager {

    @Autowired
    GameController controller;

    private static ActionSequence actionSequence;

    @Override
    public ActionSequence testSolution(String javascript) throws ScriptException {
        LevelManager.setActionSequence(new ActionSequence());
        controller.executeScript(javascript);
        return LevelManager.getActionSequence();
    }

    @Override
    public ActionSequence testSolution(LevelState levelState, String javascript) throws ScriptException {
        return controller.executeScript(javascript);
    }


    public static ActionSequence getActionSequence() {
        return actionSequence;
    }
}
