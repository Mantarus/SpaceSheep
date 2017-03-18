package com.ottepel_hack.game;

import com.ottepel_hack.game.LevelObject;
import com.ottepel_hack.game.LevelState;

/**
 * Created by iistomin on 18/03/17.
 */
public class TileSet extends LevelObject {
    public static final String TERRAIN = "TERRAIN";
    public static final String EMPTY = "EMPTY";

    private String type;

    public TileSet() {
    }

    public TileSet(Integer xPos, Integer yPos, boolean terrain) {
        super(xPos, yPos);
        this.type = terrain ? TERRAIN : EMPTY;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
