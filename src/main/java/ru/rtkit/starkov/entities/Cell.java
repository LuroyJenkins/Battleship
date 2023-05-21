package ru.rtkit.starkov.entities;

import ru.rtkit.starkov.entities.ships.Ship;

public class Cell {
    private int x, y;
    private Ship shipLink;
    private boolean isBusy;
    private boolean isExploded;
    private boolean isReserved;
    private boolean isShoted;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        shipLink = null;
        isBusy = false;
        isExploded = false;
        isReserved = false;
        isShoted = false;
    }

    public void setShipLink(Ship shipLink) {
        this.shipLink = shipLink;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public void setShoted(boolean shoted) {
        isShoted = shoted;
    }

    public void setExploded(boolean exploded) {
        isExploded = exploded;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public boolean isExploded() {
        return isExploded;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public boolean isShoted() {
        return isShoted;
    }

    public Ship getShipLink() {
        return shipLink;
    }

    @Override
    public String toString() {
        if (!isBusy && isExploded)
            return "🔘";
        else if (isBusy && !isExploded) {
            return "🚢";
        } else if (isBusy && isExploded)
            return "🟥";
        else
            return "⬜";
    }
}
