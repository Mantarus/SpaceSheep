package com.ottepel_hack.managers;

import com.ottepel_hack.controllers.SolutionResponseBody;
import com.ottepel_hack.game.GameController;
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

    private static ActionSequence actionSequence;

    @Override
    public ActionSequence testSolution(String javascript) throws ScriptException {
        return null;
    }

    @Override
    public SolutionResponseBody testSolution(LevelState levelState, String javascript) throws ScriptException {
        GameController controller = new GameController();
        return controller.executeScript(javascript, levelState);
    }


    public static ActionSequence getActionSequence() {
        return actionSequence;
    }
}
