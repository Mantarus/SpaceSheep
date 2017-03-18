package com.ottepel_hack.game.tilesets;

import com.ottepel_hack.game.LevelState;

/**
 * Created by iistomin on 18/03/17.
 */
public class TerrainTileSet extends TileSet {

    public TerrainTileSet() {
        type = "TERRAIN";
    }

    public TerrainTileSet(LevelState levelState, Integer xPos, Integer yPos) {
        super(levelState, xPos, yPos);
        type = "TERRAIN";
    }
}
