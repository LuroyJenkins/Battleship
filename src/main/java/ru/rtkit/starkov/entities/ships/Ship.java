package ru.rtkit.starkov.entities.ships;

import ru.rtkit.starkov.entities.GameBoard;

public abstract class Ship implements ShipStatus {
    private GameBoard gameBoard;

    public Ship(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }
}
