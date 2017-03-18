package com.ottepel_hack.game.tilesets;

import com.ottepel_hack.game.LevelObject;
import com.ottepel_hack.game.LevelState;

/**
 * Created by iistomin on 18/03/17.
 */
public abstract class TileSet extends LevelObject {

    protected String type;

    public TileSet() {
    }

    public TileSet(LevelState levelState, Integer xPos, Integer yPos) {
        super(levelState, xPos, yPos);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
