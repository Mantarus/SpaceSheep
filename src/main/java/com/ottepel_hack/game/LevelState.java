package com.ottepel_hack.game;

import com.ottepel_hack.game.keypoints.Finish;
import com.ottepel_hack.game.keypoints.Sheep;
import com.ottepel_hack.game.keypoints.Start;

import java.util.List;

/**
 * Created by iistomin on 18/03/17.
 */
public class LevelState {

    private List<List<TileSet>> tiles;
    private Sheep sheep;
    private Start start;
    private Finish finish;

    public LevelState() {
    }

    public LevelState(List<List<TileSet>> tiles, Sheep sheep, Start start, Finish finish) {
        this.tiles = tiles;
        this.sheep = sheep;
        this.start = start;
        this.finish = finish;
    }

    public List<List<TileSet>> getTiles() {
        return tiles;
    }

    public void setTiles(List<List<TileSet>> tiles) {
        this.tiles = tiles;
    }

    public Sheep getSheep() {
        return sheep;
    }

    public void setSheep(Sheep sheep) {
        this.sheep = sheep;
    }

    public Start getStart() {
        return start;
    }

    public void setStart(Start start) {
        this.start = start;
    }

    public Finish getFinish() {
        return finish;
    }

    public void setFinish(Finish finish) {
        this.finish = finish;
    }
}
