package com.ottepel_hack.game;

import com.ottepel_hack.game.keypoints.Finish;
import com.ottepel_hack.game.keypoints.Sheep;
import com.ottepel_hack.game.keypoints.Start;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iistomin on 18/03/17.
 */
@Component
public class LevelManager {

    private static LevelState levelState;
    private static Sheep sheep = levelState.getSheep();
    private static List<List<TileSet>> tiles = levelState.getTiles();

    public static LevelState getNewLevel() {
        levelState = new LevelState();
        Start start = new Start(levelState, 4, 0);
        Finish finish = new Finish(levelState, 9, 3);
        Sheep sheep = new Sheep(levelState, start.xPos, start.yPos);
        List<List<TileSet>> map = new ArrayList<>();

        for (int y = 0; y < 5; y++) {
            map.add(new ArrayList<>());
                for (int x = 0; x < 10; x++) {
                    map.get(y).add(new TileSet(x, y,  false));
                }
        }

        List<String> lvl = new ArrayList<>();
        lvl.add("1111011111");
        lvl.add("1000001111");
        lvl.add("1110000111");
        lvl.add("1110000000");
        lvl.add("0000000000");

        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 10; x++) {
                char c = lvl.get(y).charAt(x);
                map.get(y).get(x).setType(c == '1' ? TileSet.TERRAIN : TileSet.EMPTY);
            }
        }

        printLevel();

        levelState.setSheep(sheep);
        levelState.setStart(start);
        levelState.setFinish(finish);
        levelState.setTiles(map);
        return levelState;
    }

    private static void printLevel() {
        for (int y = 4; y >= 0; y--) {
            for (int x = 0; x < 10; x++) {
                if (sheep.getxPos() == x && sheep.getyPos() == y) {
                    System.out.print('S');
                } else {
                    System.out.print(levelState.getTiles().get(y).get(x).getType().equals(TileSet.TERRAIN) ? '#' : '0');
                }
            }
            System.out.println();
        }
    }

    public static void fail() {
        System.out.println("FAIL");
    }

    public static void finish() {
        System.out.println("FINISH");
    }

    public static void moveLeft() {
        if (checkLeft()) {
            moveSheep(-1, 0);
        }
        fall();
    }

    public static void moveRight() {
        if (checkRight()) {
            moveSheep(1, 0);
        }
        fall();
    }

    public static void climbLeft() {
        if (!checkLeft() && checkUp() && checkUpLeft()) {
            moveUp();
            moveLeft();
        }
    }

    public static void climbRight() {
        if (!checkRight() && checkUp() && checkUpRight()) {
            moveUp();
            moveRight();
        }
    }

    public static void jump() {
        moveUp();
        fall();
    }

    public static void jumpLeft() {
        int x = sheep.getxPos();
        int y = sheep.getyPos();
        if (checkUp() && checkUpLeft() && checkLeft() && checkTile(x - 2, y) && checkTile(x - 2, y + 1)) {
            moveSheep(-2, 0);
            fall();
        }
    }

    public static void jumpRight() {
        int x = sheep.getxPos();
        int y = sheep.getyPos();
        if (checkUp() && checkUpRight() && checkRight() && checkTile(x + 2, y) && checkTile(x + 2, y + 1)) {
            moveSheep(2, 0);
            fall();
        }
    }

    private static void moveSheep(int x, int y) {
        Sheep sheep = levelState.getSheep();
        sheep.setxPos(sheep.getxPos() + x);
        sheep.setyPos(sheep.getyPos() + y);
    }

    private static void moveUp() {
        if (checkUp()) {
            moveSheep(0, 1);
        }
    }

    private static void moveDown() {
        if (checkDown()) {
            moveSheep(0, -1);
        }
    }

    private static void fall() {
        while(checkDown()) {
            moveDown();
            if (sheep.getyPos() - 1 < 0) {
                fail();
            }
        }
    }

    private static boolean checkLeft() {
        int x = sheep.getxPos();
        int y = sheep.getyPos();
        return checkTile(x - 1, y);
    }

    private static boolean checkRight() {
        int x = sheep.getxPos();
        int y = sheep.getyPos();
        return checkTile(x + 1, y);
    }

    private static boolean checkUp() {
        int x = sheep.getxPos();
        int y = sheep.getyPos();
        return checkTile(x, y + 1);
    }

    private static boolean checkDown() {
        int x = sheep.getxPos();
        int y = sheep.getyPos();
        return checkTile(x, y - 1);
    }

    private static boolean checkUpLeft() {
        int x = sheep.getxPos();
        int y = sheep.getyPos();
        return checkTile(x - 1, y + 1);
    }

    private static boolean checkUpRight() {
        int x = sheep.getxPos();
        int y = sheep.getyPos();
        return checkTile(x + 1, y + 1);
    }

    private static boolean checkTile(int x, int y) {
        if (x > 9 || x < 0 || y > 4 || y < 0) {
            return false;
        }
        return levelState.getTiles().get(y).get(x).getType().equals(TileSet.EMPTY);
    }

}
