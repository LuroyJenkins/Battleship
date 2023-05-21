package ru.rtkit.starkov;

import ru.rtkit.starkov.entities.Cell;
import ru.rtkit.starkov.entities.GameBoard;
import ru.rtkit.starkov.entities.Utils;
import ru.rtkit.starkov.entities.ships.*;

public class Gameplay {
    public static Ship placeShipUnified(GameBoard gameBoard, int[] coordinates) {
        if (placeCheck(gameBoard, coordinates) && coordinatesAreValid(coordinates)) {
            switch (coordinates.length) {
                case 2:
                    if (gameBoard.getSpeedBoatsCount() != 4) {
                        gameBoard.setLiveShips(gameBoard.getLiveShips() + 1);
                        gameBoard.setSpeedBoatsCount(gameBoard.getSpeedBoatsCount() + 1);
                        return new Speedboat(gameBoard, coordinates[0], coordinates[1]);
                    } else {
                        System.out.println("На игровом поле уже максимальное количество однопалубных кораблей!");
                        break;
                    }
                case 4:
                    if (gameBoard.getDestroyersCount() != 3) {
                        gameBoard.setLiveShips(gameBoard.getLiveShips() + 1);
                        gameBoard.setDestroyersCount(gameBoard.getDestroyersCount() + 1);
                        return new Destroyer(gameBoard, coordinates[0], coordinates[1], coordinates[2], coordinates[3]);
                    } else {
                        System.out.println("На игровом поле уже максимальное количество двухпалубных кораблей!");
                        break;
                    }
                case 6:
                    if (gameBoard.getCruisersCount() != 2) {
                        gameBoard.setLiveShips(gameBoard.getLiveShips() + 1);
                        gameBoard.setCruisersCount(gameBoard.getCruisersCount() + 1);
                        return new Cruiser(gameBoard, coordinates[0], coordinates[1], coordinates[2], coordinates[3],
                                coordinates[4], coordinates[5]);
                    } else {
                        System.out.println("На игровом поле уже максимальное количество трехпалубных кораблей!");
                        break;
                    }
                case 8:
                    if (gameBoard.getBattleShipsCount() != 1) {
                        gameBoard.setLiveShips(gameBoard.getLiveShips() + 1);
                        gameBoard.setBattleShipsCount(gameBoard.getBattleShipsCount() + 1);
                        return new Battleship(gameBoard, coordinates[0], coordinates[1], coordinates[2], coordinates[3],
                                coordinates[4], coordinates[5], coordinates[6], coordinates[7]);
                    } else {
                        System.out.println("На игровом поле уже максимальное количество четырехпалубных кораблей!");
                        break;
                    }
                default:
                    System.out.println("Вы ввели неверное количество координат! Введите снова");
                    return null;
            }
        }
        System.out.println("Вы ввели некорректные координаты! Введите снова");
        return null;
    }
//    public static Ship placeShip(GameBoard gameBoard, int x1, int y1) {
//        int[] coordinates = {x1, y1};
//        if (placeCheck(gameBoard, coordinates)) {
//            gameBoard.setLiveShips(gameBoard.getLiveShips() + 1);
//            return new Speedboat(gameBoard, x1, y1);
//        } else return null;
//    }
//
//    public static Ship placeShip(GameBoard gameBoard, int x1, int y1, int x2, int y2) {
//        int[] coordinates = {x1, y1, x2, y2};
//        if (placeCheck(gameBoard, coordinates)) {
//            gameBoard.setLiveShips(gameBoard.getLiveShips() + 1);
//            return new Destroyer(gameBoard, x1, x2, y1, y2);
//        } else return null;
//    }
//
//    public static Ship placeShip(GameBoard gameBoard, int x1, int y1, int x2, int y2, int x3, int y3) {
//        int[] coordinates = {x1, y1, x2, y2, x3, y3};
//        if (placeCheck(gameBoard, coordinates)) {
//            gameBoard.setLiveShips(gameBoard.getLiveShips() + 1);
//            return new Cruiser(gameBoard, x1, x2, x3, y1, y2, y3);
//        }
//        return null;
//    }
//
//    public static Ship placeShip(GameBoard gameBoard, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
//        int[] coordinates = {x1, y1, x2, y2, x3, y3, x4, y4};
//        if (placeCheck(gameBoard, coordinates)) {
//            gameBoard.setLiveShips(gameBoard.getLiveShips() + 1);
//            return new Battleship(gameBoard, x1, x2, x3, x4, y1, y2, y3, y4);
//        }
//        return null;
//    }

    public static void move(GameBoard gameBoard, int[] coordinates) {
        Cell cell = gameBoard.getGameBoard()[coordinates[0]][coordinates[1]];
        if (cell.isBusy() && !cell.isExploded()
                && cell.getShipLink().isAlive()) {
            cell.setExploded(true);
            if (cell.getShipLink().isAlive()) {
                System.out.println("Попадание!");
                System.out.print("Дополнительный ход. Введи координаты для выстрела в формате 'X Y': ");
                move(gameBoard, Utils.coordinatesLineParsing(Interface.scanner.nextLine()));
            } else {
                System.out.println("Утопил!");
                gameBoard.setLiveShips(gameBoard.getLiveShips() - 1);
                if (gameBoard.getLiveShips() != 0) {
                    System.out.print("Дополнительный ход. Введи координаты для выстрела в формате 'X Y': ");
                    move(gameBoard, Utils.coordinatesLineParsing(Interface.scanner.nextLine()));
                }
            }
        } else if (!cell.isBusy()) {
            System.out.println("Мимо!");
        }
    }

    public static boolean placeCheck(GameBoard gameBoard, int[] coordinates) {
        for (int i = 0; i < coordinates.length; i += 2) {
            Cell cell = gameBoard.getGameBoard()[coordinates[i]][coordinates[i + 1]];
            if (cell.isBusy() || cell.isReserved())
                return false;
        }
        return true;
    }

    public static boolean coordinatesAreValid(int[] coordinates) {
        int[] coordinatesX = new int[coordinates.length / 2];
        int[] coordinatesY = new int[coordinates.length / 2];
        int j = 0;
        for (int i = 0; i < coordinates.length; i += 2) {
            coordinatesX[j] = coordinates[i];
            coordinatesY[j] = coordinates[i + 1];
            j++;
        }

        return (isOneAxis(coordinatesX) && inOneStep(coordinatesY)) || (isOneAxis(coordinatesY) && inOneStep(coordinatesX));

    }

    public static boolean isOneAxis(int[] coordinates) {
        int comparator = coordinates[0];
        for (int coordinate : coordinates) {
            if (comparator != coordinate) {
                return false;
            }
        }
        return true;
    }

    public static boolean inOneStep(int[] coordinates) {
        for (int i = 0; i < coordinates.length - 1; i++) {
            if (coordinates[i + 1] - coordinates[i] != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean victoryCheck(GameBoard gameBoard1, GameBoard gameBoard2) {
        if (gameBoard1.getLiveShips() == 0) {
            System.out.println("Победил игрок " + gameBoard2.getPlayerName() + "! Поздравляем!");
            return true;
        } else if (gameBoard2.getLiveShips() == 0) {
            System.out.println("Победил игрок " + gameBoard1.getPlayerName() + "! Поздравляем!");
            return true;
        }
        return false;
    }
}
