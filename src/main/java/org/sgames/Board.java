package org.sgames;

import java.util.HashMap;
import java.util.Map;

public class Board {
    //8 snakes
    private final Map<Integer, Integer> snakeList = new HashMap<>();
    //8 Ladders
    private final Map<Integer, Integer> ladderList = new HashMap<>();

    public Board() {
        snakeList.put(17, 7);
        snakeList.put(54, 34);
        snakeList.put(62, 19);
        snakeList.put(64, 60);
        snakeList.put(87, 36);
        snakeList.put(93, 73);
        snakeList.put(95, 75);
        snakeList.put(98, 79);

        ladderList.put(2, 38);
        ladderList.put(4, 14);
        ladderList.put(9, 31);
        ladderList.put(28, 84);
        ladderList.put(21, 42);
        ladderList.put(51, 67);
        ladderList.put(72, 91);
        ladderList.put(80, 99);

    }

    public int validate(int currentPosition) {
        if (snakeList.containsKey(currentPosition)) {
            System.out.println("Ohh! ☹️, Bitten by a snake 🐍, " + "\n going down to " + snakeList.get(currentPosition));
            return snakeList.get(currentPosition);
        }
        if (ladderList.containsKey(currentPosition)) {
            System.out.println("Wow! 😊, Got a ladder 🪜," + " \n going up to " + ladderList.get(currentPosition));
            return ladderList.get(currentPosition);
        }
        return currentPosition;
    }
}
