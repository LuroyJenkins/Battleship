package ru.rtkit.starkov.entities;

import static ru.rtkit.starkov.Interface.scanner;

public class GameBoard {
    private Cell[][] gameBoard = new Cell[10][10];
    private int liveShips;
    private int battleShipsCount;
    private int cruisersCount;
    private int destroyersCount;
    private int speedBoatsCount;
    private final String playerName;

    public GameBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                gameBoard[i][j] = new Cell(i, j);
            }
        }
        liveShips = 0;
        battleShipsCount = 0;
        cruisersCount = 0;
        destroyersCount = 0;
        speedBoatsCount = 0;
        System.out.print("Игрок, введите имя: ");
        playerName = scanner.nextLine();
    }

    public void setLiveShips(int liveShips) {
        this.liveShips = liveShips;
    }

    public void setBattleShipsCount(int battleShipsCount) {
        this.battleShipsCount = battleShipsCount;
    }

    public void setCruisersCount(int cruisersCount) {
        this.cruisersCount = cruisersCount;
    }

    public void setDestroyersCount(int destroyersCount) {
        this.destroyersCount = destroyersCount;
    }

    public void setSpeedBoatsCount(int speedBoatsCount) {
        this.speedBoatsCount = speedBoatsCount;
    }

    public Cell[][] getGameBoard() {
        return gameBoard;
    }

    public int getLiveShips() {
        return liveShips;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getBattleShipsCount() {
        return battleShipsCount;
    }

    public int getCruisersCount() {
        return cruisersCount;
    }

    public int getDestroyersCount() {
        return destroyersCount;
    }

    public int getSpeedBoatsCount() {
        return speedBoatsCount;
    }

    public void printGameBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(gameBoard[j][i]);
            }
            System.out.println();
        }
    }
}
