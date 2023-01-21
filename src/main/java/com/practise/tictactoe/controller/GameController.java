package com.practise.tictactoe.controller;

import com.practise.tictactoe.models.Game;
import com.practise.tictactoe.models.GameState;
import com.practise.tictactoe.models.GameWinningType;
import com.practise.tictactoe.models.Player;

import java.util.List;

public class GameController {
  public Game createGame(int dimension, List<Player> players, GameWinningType gameWinningType) {
    return Game.builder().setDimension(dimension).setPlayers(players).setGameWinningType(gameWinningType).build();
  }

  public GameState getGameStatus(Game game) {
    return game.getGameState();
  }

  public void displayBoard(Game game) {
    game.getBoard().displayBoard();
  }

  public void executeNextMove(Game game) {
    game.makeNextMove();
  }

  public Player getWinnerOfGame(Game game) {
    return game.getWinner();
  }

}
