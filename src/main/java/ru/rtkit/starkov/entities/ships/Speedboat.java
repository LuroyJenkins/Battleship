package ru.rtkit.starkov.entities.ships;

import ru.rtkit.starkov.entities.GameBoard;

public class Speedboat extends Ship implements ShipStatus{
    private final int x1, y1;

    public Speedboat(GameBoard gameBoard, int x1, int y1) {
        super(gameBoard);

        this.x1 = x1;
        this.y1 = y1;

        getGameBoard().getGameBoard()[x1][y1].setShipLink(this);
        getGameBoard().getGameBoard()[x1][y1].setBusy(true);
    }

    @Override
    public boolean isAlive() {
        return !getGameBoard().getGameBoard()[x1][y1].isExploded();
    }
}
