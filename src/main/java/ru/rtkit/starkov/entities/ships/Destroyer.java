package ru.rtkit.starkov.entities.ships;

import ru.rtkit.starkov.entities.GameBoard;

public class Destroyer extends Ship implements ShipStatus{
    private int x1, x2, y1, y2;

    public Destroyer(GameBoard gameBoard, int x1, int y1, int x2, int y2) {
        super(gameBoard);

        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

        getGameBoard().getGameBoard()[x1][y1].setShipLink(this);
        getGameBoard().getGameBoard()[x1][y1].setBusy(true);

        getGameBoard().getGameBoard()[x2][y2].setShipLink(this);
        getGameBoard().getGameBoard()[x2][y2].setBusy(true);
    }

    @Override
    public boolean isAlive() {
        return !getGameBoard().getGameBoard()[x1][y1].isExploded() ||
                !getGameBoard().getGameBoard()[x2][y2].isExploded();
    }
}
