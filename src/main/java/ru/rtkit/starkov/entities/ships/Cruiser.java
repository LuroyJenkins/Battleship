package ru.rtkit.starkov.entities.ships;

import ru.rtkit.starkov.entities.GameBoard;

public class Cruiser extends Ship implements ShipStatus{
    private final int x1, x2, x3, y1, y2, y3;

    public Cruiser(GameBoard gameBoard, int x1, int y1, int x2, int y2, int x3, int y3) {
        super(gameBoard);

        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;

        getGameBoard().getGameBoard()[x1][y1].setShipLink(this);
        getGameBoard().getGameBoard()[x1][y1].setBusy(true);

        getGameBoard().getGameBoard()[x2][y2].setShipLink(this);
        getGameBoard().getGameBoard()[x2][y2].setBusy(true);

        getGameBoard().getGameBoard()[x3][y3].setShipLink(this);
        getGameBoard().getGameBoard()[x3][y3].setBusy(true);
    }

    @Override
    public boolean isAlive() {
        return !getGameBoard().getGameBoard()[x1][y1].isExploded() ||
                !getGameBoard().getGameBoard()[x2][y2].isExploded() ||
                !getGameBoard().getGameBoard()[x3][y3].isExploded();
    }
}
