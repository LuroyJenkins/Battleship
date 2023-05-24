package ru.rtkit.starkov;

import ru.rtkit.starkov.entities.GameBoard;
import ru.rtkit.starkov.entities.Utils;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Interface {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        GameBoard gameBoard1 = new GameBoard();
        GameBoard gameBoard2 = new GameBoard();

        enteringCoordinates(gameBoard1);
        resultAnnouncement(gameBoard1);
        System.out.println("Нажмите Enter для продолжения...");
        scanner.nextLine();
        for(int i = 0; i < 100; i++){
            System.out.println();
        }
        enteringCoordinates(gameBoard2);
        resultAnnouncement(gameBoard1);
        System.out.println("Нажмите Enter для продолжения...");
        scanner.nextLine();
        for(int i = 0; i < 100; i++){
            System.out.println();
        }
        phaseOfMoves(gameBoard1, gameBoard2);
    }

    public static void enteringCoordinates(GameBoard gameBoard) {
        System.out.println("Игрок - " + gameBoard.getPlayerName() + ", задай координаты своих кораблей:");
        do {
            System.out.println("Введи координаты четырехпалубного корабля (формат: x1,y1;x2,y2;x3,y3;x4,y4)");
        } while (Gameplay.placeShipUnified(gameBoard, Utils.coordinatesLineParsing(scanner.nextLine())) == null);
        for (int i = 0; i < 2; i++) {
            do {
                System.out.println("Введи координаты трехпалубного корабля (формат: x1,y1;x2,y2;x3,y3)");
            } while (Gameplay.placeShipUnified(gameBoard, Utils.coordinatesLineParsing(scanner.nextLine())) == null);
        }
        for (int i = 0; i < 3; i++) {
            do {
                System.out.println("Введи координаты двухпалубного корабля (формат: x1,y1;x2,y2)");
            } while (Gameplay.placeShipUnified(gameBoard, Utils.coordinatesLineParsing(scanner.nextLine())) == null);
        }
        for (int i = 0; i < 4; i++) {
            do {
                System.out.println("Введи координаты однопалубного корабля (формат: x1,y1)");
            } while (Gameplay.placeShipUnified(gameBoard, Utils.coordinatesLineParsing(scanner.nextLine())) == null);
        }
    }

    public static void phaseOfMoves(GameBoard gameBoard1, GameBoard gameBoard2) {
        if (ThreadLocalRandom.current().nextInt(1, 3) == 1) {
            while (!Gameplay.victoryCheck(gameBoard1, gameBoard2)) {
                playersTurn(gameBoard1, gameBoard2);
            }
        } else
            playersTurn(gameBoard2, gameBoard1);
        resultAnnouncement(gameBoard1);
        resultAnnouncement(gameBoard2);
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
        String input;
        while (true) {
            input = scanner.nextLine();
            if (Utils.coordinatesLineParsing(input).length == 2)
                break;
            else System.out.println("Ты ввел некорректные координаты, попробуй снова!");
        }
        Gameplay.move(gameBoard, Utils.coordinatesLineParsing(input));
    }

    public static void resultAnnouncement(GameBoard gameBoard) {
        System.out.println("Поле игрока " + gameBoard.getPlayerName());
        gameBoard.printGameBoard();
        System.out.println();
    }
}
