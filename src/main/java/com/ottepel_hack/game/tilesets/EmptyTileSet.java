package com.ottepel_hack.game.tilesets;

import com.ottepel_hack.game.LevelState;

/**
 * Created by iistomin on 18/03/17.
 */
public class EmptyTileSet extends TileSet {



    public EmptyTileSet() {
        type = "EMPTY";
    }

    public EmptyTileSet(LevelState levelState, Integer xPos, Integer yPos) {
        super(levelState, xPos, yPos);
        type = "EMPTY";
    }
}
