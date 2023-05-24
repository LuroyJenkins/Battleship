package ru.rtkit.starkov.entities.ships;

import ru.rtkit.starkov.entities.GameBoard;

public class Battleship extends Ship implements ShipStatus {
    private final int x1, x2, x3, x4, y1, y2, y3, y4;

    public Battleship(GameBoard gameBoard, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        super(gameBoard);

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;

        getGameBoard().getGameBoard()[x1][y1].setShipLink(this);
        getGameBoard().getGameBoard()[x1][y1].setBusy(true);

        getGameBoard().getGameBoard()[x2][y2].setShipLink(this);
        getGameBoard().getGameBoard()[x2][y2].setBusy(true);

        getGameBoard().getGameBoard()[x3][y3].setShipLink(this);
        getGameBoard().getGameBoard()[x3][y3].setBusy(true);

        getGameBoard().getGameBoard()[x4][y4].setShipLink(this);
        getGameBoard().getGameBoard()[x4][y4].setBusy(true);
    }

    @Override
    public boolean isAlive() {
        return !getGameBoard().getGameBoard()[x1][y1].isExploded() ||
                !getGameBoard().getGameBoard()[x2][y2].isExploded() ||
                !getGameBoard().getGameBoard()[x3][y3].isExploded() ||
                !getGameBoard().getGameBoard()[x4][y4].isExploded();
    }
}
