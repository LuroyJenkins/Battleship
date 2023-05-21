package ru.rtkit.starkov;

import ru.rtkit.starkov.entities.GameBoard;
import ru.rtkit.starkov.entities.Utils;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Interface {
    public static Scanner scanner = new Scanner(System.in);
    private static String input;

    public static void main(String[] args) {
        GameBoard gameBoard1 = new GameBoard();
        GameBoard gameBoard2 = new GameBoard();

        enteringCoordinates(gameBoard1);
        enteringCoordinates(gameBoard2);

        phaseOfMoves(gameBoard1, gameBoard2);
    }

    public static void enteringCoordinates(GameBoard gameBoard) {
        System.out.println("Игрок - " + gameBoard.getPlayerName() + ", задай координаты своих кораблей:");
        while (true){
            System.out.println("Введи координаты четырехпалубного корабля (формат: x1,y1;x2,y2;x3,y3;x4,y4)");
            if(Gameplay.placeShipUnified(gameBoard, Utils.coordinatesLineParsing(scanner.nextLine())) != null)
                break;
        }
        for (int i = 0; i < 2; i++) {
            System.out.println("Введи координаты трехпалубного корабля (формат: x1,y1;x2,y2;x3,y3)");
            if(Gameplay.placeShipUnified(gameBoard, Utils.coordinatesLineParsing(scanner.nextLine())) == null)
                i--;
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("Введи координаты двухпалубного корабля (формат: x1,y1;x2,y2)");
            Gameplay.placeShipUnified(gameBoard, Utils.coordinatesLineParsing(scanner.nextLine()));
        }
        for (int i = 0; i < 4; i++) {
            System.out.println("Введи координаты однопалубного корабля (формат: x1,y1)");
            Gameplay.placeShipUnified(gameBoard, Utils.coordinatesLineParsing(scanner.nextLine()));
        }

    }

    public static void phaseOfMoves(GameBoard gameBoard1, GameBoard gameBoard2) {
        if (ThreadLocalRandom.current().nextInt(1, 3) == 1) {
            while (!Gameplay.victoryCheck(gameBoard1, gameBoard2)) {
                playersTurn(gameBoard1, gameBoard2);
            }
        } else
            playersTurn(gameBoard2, gameBoard1);
        resultAnnouncement(gameBoard1, gameBoard2);
    }

    public static void playersTurn(GameBoard player1, GameBoard player2) {
        while (!Gameplay.victoryCheck(player1, player2)) {
            System.out.println(player1.getPlayerName() + ", введи координаты для выстрела (формат: x,y");
            playerInputMove(player2);
            if (!Gameplay.victoryCheck(player1, player2)) {
                System.out.println(player2.getPlayerName() + ", введи координаты для выстрела (формат: x,y");
                playerInputMove(player1);
            } else break;
        }
    }

    public static void playerInputMove(GameBoard gameBoard) {
        while (true) {
            input = scanner.nextLine();
            if (Utils.coordinatesLineParsing(input).length == 2)
                break;
            else System.out.println("Ты ввел некорректные координаты, попробуй снова!");
        }
        Gameplay.move(gameBoard, Utils.coordinatesLineParsing(input));
    }

    public static void resultAnnouncement(GameBoard gameBoard1, GameBoard gameBoard2) {
        System.out.println("Поле игрока " + gameBoard1.getPlayerName());
        gameBoard1.printGameBoard();
        System.out.println();
        System.out.println("Поле игрока " + gameBoard2.getPlayerName());
        gameBoard2.printGameBoard();
    }
}
