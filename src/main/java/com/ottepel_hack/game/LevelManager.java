package com.ottepel_hack.game;

import com.ottepel_hack.game.keypoints.Finish;
import com.ottepel_hack.game.keypoints.Sheep;
import com.ottepel_hack.game.keypoints.Start;
import com.ottepel_hack.managers.ActionSequence;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iistomin on 18/03/17.
 */
@Component
public class LevelManager {

    private static LevelState levelState;
    private static Sheep sheep;
    private static ActionSequence actionSequence;

    public static ActionSequence getActionSequence() {
        return actionSequence;
    }

    public static void setActionSequence(ActionSequence actionSequence) {
        LevelManager.actionSequence = actionSequence;
    }

    public static LevelState getNewLevel() {
        levelState = new LevelState();
        Start start = new Start(levelState, 0, 4);
        Finish finish = new Finish(levelState, 9, 3);
        sheep = new Sheep(levelState, start.xPos, start.yPos);
        List<List<TileSet>> map = new ArrayList<>();

        levelState.setSheep(sheep);
        levelState.setStart(start);
        levelState.setFinish(finish);
        levelState.setTiles(map);

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
        System.out.println("fail");
        actionSequence.getSequence().add("fail");
    }

    public static void checkFinish() {
        if (sheep.getxPos() == levelState.getFinish().getxPos() &&
                sheep.getyPos() == levelState.getFinish().getyPos()) {
            System.out.println("finish");
            actionSequence.getSequence().add("finish");
            printLevel();
        }
    }

    public static void moveLeft() {
        if (checkLeft()) {
            moveSheep(-1, 0);
            System.out.println("moveLeft");
            actionSequence.getSequence().add("moveLeft");
            fall();
            checkFinish();
            printLevel();
        }
    }

    public static void moveRight() {
        if (checkRight()) {
            moveSheep(1, 0);
            System.out.println("moveRight");
            actionSequence.getSequence().add("moveRight");
            fall();
            checkFinish();
            printLevel();
        }
    }

    public static void climbLeft() {
        if (!checkLeft() && checkUp() && checkUpLeft()) {
            System.out.println("climbLeft");
            actionSequence.getSequence().add("climbLeft");
            moveSheep(-1, 1);
            fall();
            checkFinish();
            printLevel();
        }
    }

    public static void climbRight() {
        if (!checkRight() && checkUp() && checkUpRight()) {
            System.out.println("climbRight");
            actionSequence.getSequence().add("climbRight");
            moveSheep(1, 1);
            fall();
            checkFinish();
            printLevel();
        }
    }

    public static void jump() {
        if (checkUp()) {
            System.out.println("jump");
            actionSequence.getSequence().add("jump");
        }
        printLevel();
    }

    public static void jumpLeft() {
        int x = sheep.getxPos();
        int y = sheep.getyPos();
        if (checkUp() && checkUpLeft() && checkLeft() && checkTile(x - 2, y) && checkTile(x - 2, y + 1)) {
            moveSheep(-2, 0);
            System.out.println("jumpLeft");
            actionSequence.getSequence().add("jumpLeft");
            fall();
            checkFinish();
            printLevel();
        }
    }

    public static void jumpRight() {
        int x = sheep.getxPos();
        int y = sheep.getyPos();
        if (checkUp() && checkUpRight() && checkRight() && checkTile(x + 2, y) && checkTile(x + 2, y + 1)) {
            moveSheep(2, 0);
            System.out.println("jumpRight");
            actionSequence.getSequence().add("jumpRight");
            fall();
            checkFinish();
            printLevel();
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
            System.out.println("moveDown");
            actionSequence.getSequence().add("moveDown");
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
