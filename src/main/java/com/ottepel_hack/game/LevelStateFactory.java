package com.ottepel_hack.game;

import com.ottepel_hack.game.keypoints.Finish;
import com.ottepel_hack.game.keypoints.Sheep;
import com.ottepel_hack.game.keypoints.Start;
import com.ottepel_hack.game.tilesets.EmptyTileSet;
import com.ottepel_hack.game.tilesets.TerrainTileSet;
import com.ottepel_hack.game.tilesets.TileSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iistomin on 18/03/17.
 */
@Component
public class LevelStateFactory {

    public LevelState getSimpleLevel() {
        LevelState level = new LevelState();
        Start start = new Start(level, 0, 0);
        Finish finish = new Finish(level, 0, 4);
        Sheep sheep = new Sheep(level, start.xPos, start.yPos);
        List<List<TileSet>> map = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < 5; i++) {
            map.get(0).add(new EmptyTileSet(level, i, 0));
            map.get(1).add(new TerrainTileSet(level, i, 1));
        }

        level.setSheep(sheep);
        level.setStart(start);
        level.setFinish(finish);
        level.setTiles(map);
        return level;
    }

}
