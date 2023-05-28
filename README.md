# Battleship Console Game🚢

- This is a console-based implementation of the classic [game Battleship](https://en.wikipedia.org/wiki/Battleship_(game)) with an improved CLI graphics system.
- The final project of Marathon "Practice for beginners" in Java by [Nail Alishev](https://www.youtube.com/@alishevN)
- **Stack:** Java, Gradle
- [Task](https://docs.google.com/document/d/1Pu-8OsB72fqkj3VfigI1Lupvng_RdqXzLaCtlmLqxnk/edit?usp=drivesdk)

## Getting started:
You will need to have Java 8+ and Gradle installed on your computer to run this game.

## Installation:
1. Clone or download this repository to your local machine.
2. Navigate to the project directory.
3. Compile the `Interface.java` file by running the command javac `Main.java` in the terminal.
4. Run the game by entering the command `java Main` in the terminal.

## How to win:
- Each player has a battlefield represented by a 10x10 grid (default) on which he places 10 ships, hidden from his opponent.
- The goal of the game is to sink all the opposing ships! A ship is sunk when it is hit once for each space it occupies.
- In other words, a submarine, which occupies two spaces, is sunk after being hit twice.

## Place your ships:
To place a ship you need to enter a departure coordinate (1.1-10.10 for the default 10x10 board) and a direction (vertical or horizontal).
- For example: "1" and '6' or "5" and '8'.

Ships shall not overlap or be adjacent and shall remain within the boundaries of the edge.

<img width="456" alt="image" src="https://github.com/LuroyJenkins/Battleship/assets/99817031/0017fb5f-a342-47ca-85dd-2d097a7f41be">

## Shoot the enemy ships:

Once both players have configured their ships, the battle may have started!

- Shoot your opponent’s ships by matching the coordinates.
- You will be informed if you have hit or missed a ship.
- Sink all 10 another player ships to win!

<img width="419" alt="image" src="https://github.com/LuroyJenkins/Battleship/assets/99817031/11ca0b8e-e3e9-4ebb-b476-25bccb4de889">

## End game:
If all the ships of one of the players are destroyed, the game ends.

<img width="231" alt="image" src="https://github.com/LuroyJenkins/Battleship/assets/99817031/c884cae5-fc34-43c4-a801-c43968573edd">

