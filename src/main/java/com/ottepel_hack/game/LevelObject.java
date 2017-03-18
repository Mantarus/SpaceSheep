package com.ottepel_hack.game;

/**
 * Created by iistomin on 18/03/17.
 */
public abstract class LevelObject {

//    protected LevelState levelState;
    protected Integer xPos;
    protected Integer yPos;

    public LevelObject() {
    }

    public LevelObject(Integer xPos, Integer yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public Integer getxPos() {
        return xPos;
    }

    public void setxPos(Integer xPos) {
        this.xPos = xPos;
    }

    public Integer getyPos() {
        return yPos;
    }

    public void setyPos(Integer yPos) {
        this.yPos = yPos;
    }
}
