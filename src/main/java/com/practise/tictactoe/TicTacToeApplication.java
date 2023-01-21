package com.practise.tictactoe;

import com.practise.tictactoe.controller.GameController;
import com.practise.tictactoe.models.Bot;
import com.practise.tictactoe.models.BotDifficultyLevel;
import com.practise.tictactoe.models.Game;
import com.practise.tictactoe.models.GameState;
import com.practise.tictactoe.models.GameWinningType;
import com.practise.tictactoe.models.Player;
import com.practise.tictactoe.models.PlayerType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

@SpringBootApplication
public class TicTacToeApplication {

  public static void main(String[] args) {
    SpringApplication.run(TicTacToeApplication.class, args);
    start();
  }

  private static void start() {
    System.out.println("Application Started");

    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter dimension of game: ");
    int dimension = scanner.nextInt();

    System.out.print("Enter the strategy to win the game (ROW_COL_DIAG, ROW_COL): ");
    GameWinningType gameWinningType = GameWinningType.valueOf(scanner.next());

    System.out.println();
    System.out.print("Will there be a bot in the game? Enter y/n: ");
    boolean isBotPlaying = "y".equals(scanner.next());

    int noOfPlayers = dimension - 1;
    int noOfPlayersToIterate = noOfPlayers;

    List<Player> players = new ArrayList<>();
    Set<Character> symbols = new HashSet<>();

    if (isBotPlaying) {
      noOfPlayersToIterate = noOfPlayersToIterate - 1;

      System.out.println();
      System.out.print("Enter the name for Bot: ");
      String name = scanner.next();

      System.out.print("Enter " + name + "'s symbol of choice: ");
      char symbol = scanner.next().charAt(0);
      symbols.add(symbol);

      System.out.print("Enter " + name + "'s difficulty level (EASY, MEDIUM, HARD): ");
      BotDifficultyLevel difficultyLevel = BotDifficultyLevel.valueOf(scanner.next());

      players.add(new Bot(name, symbol, difficultyLevel));
    }

    for (int i = 0; i < noOfPlayersToIterate; i++) {
      System.out.println();
      System.out.print("Enter the name of Player " + (i + 1) + ": ");
      String name = scanner.next();

      System.out.print("Enter " + name + "'s symbol of choice: ");
      char symbol = getValidSymbolFromPlayer(scanner, symbols);

      players.add(new Player(name, symbol, PlayerType.HUMAN));
    }
    Collections.shuffle(players);

    GameController gameController = new GameController();

    Game game = gameController.createGame(dimension, players, gameWinningType);

    while (gameController.getGameStatus(game) == GameState.IN_PROGRESS) {
      System.out.println("\nBelow is the current Board");

      gameController.displayBoard(game);
      gameController.executeNextMove(game);
    }

    System.out.println("\nGame has ended. Below is the final Board");
    gameController.displayBoard(game);
    System.out.println();
    if (gameController.getGameStatus(game) == GameState.DRAW) {
      System.out.println("It is a Draw.");
    } else {
      System.out.println("Winner is: " + gameController.getWinnerOfGame(game).getName());
    }

  }

  private static char getValidSymbolFromPlayer(Scanner scanner, Set<Character> symbols) {
    char choosenSymbol = scanner.next().charAt(0);
    while (symbols.contains(choosenSymbol)) {
      System.out.println(
          "Symbols: " + symbols + " are already selected by other players, please choose a different one.");
      System.out.print("Choose symbol: ");
      choosenSymbol = scanner.next().charAt(0);
    }
    symbols.add(choosenSymbol);
    return choosenSymbol;
  }

}
