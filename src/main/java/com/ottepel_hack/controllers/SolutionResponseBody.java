package com.ottepel_hack.controllers;

import com.ottepel_hack.game.LevelState;
import com.ottepel_hack.managers.ActionSequence;

/**
 * Created by iistomin on 18/03/17.
 */
public class SolutionResponseBody {

    private LevelState levelState;
    private ActionSequence sequence;

    public SolutionResponseBody() {
    }

    public SolutionResponseBody(LevelState levelState, ActionSequence sequence) {
        this.levelState = levelState;
        this.sequence = sequence;
    }

    public LevelState getLevelState() {
        return levelState;
    }

    public void setLevelState(LevelState levelState) {
        this.levelState = levelState;
    }

    public ActionSequence getSequence() {
        return sequence;
    }

    public void setSequence(ActionSequence sequence) {
        this.sequence = sequence;
    }
}
