package com.practise.tictactoe.models;

import com.practise.tictactoe.factories.GameWinningStrategyFactory;
import com.practise.tictactoe.strategies.gamewinningstrategy.GameWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {

  private Board board;
  private List<Player> players;
  private List<Move> moves;
  private GameState gameState;
  private int nextPlayerIndex;
  private GameWinningStrategy gameWinningStrategy;
  private Player winner;

  private Game() {

  }

  public Board getBoard() {
    return board;
  }

  public void setBoard(Board board) {
    this.board = board;
  }

  public List<Player> getPlayers() {
    return players;
  }

  public void setPlayers(List<Player> players) {
    this.players = players;
  }

  public List<Move> getMoves() {
    return moves;
  }

  public void setMoves(List<Move> moves) {
    this.moves = moves;
  }

  public GameState getGameState() {
    return gameState;
  }

  public void setGameState(GameState gameState) {
    this.gameState = gameState;
  }

  public int getNextPlayerIndex() {
    return nextPlayerIndex;
  }

  public void setNextPlayerIndex(int nextPlayerIndex) {
    this.nextPlayerIndex = nextPlayerIndex;
  }

  public GameWinningStrategy getGameWinningStrategy() {
    return gameWinningStrategy;
  }

  public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
    this.gameWinningStrategy = gameWinningStrategy;
  }

  public Player getWinner() {
    return winner;
  }

  public void setWinner(Player winner) {
    this.winner = winner;
  }

  public static Builder builder() {
    return new Builder();
  }

  public void makeNextMove() {
    Player currentPlayer = players.get(nextPlayerIndex);

    System.out.println();
    System.out.println("It is " + currentPlayer.getName() + "'s turn.");

    Move move = currentPlayer.decideMove(currentPlayer, this.board);
    while (!isValidMove(move, board)) {
      move = currentPlayer.decideMove(currentPlayer, this.board);
    }

    int row = move.getCell().getRow();
    int col = move.getCell().getCol();

    System.out.println("Move happend at row: " + row + " column: " + col + ".");
    board.getBoard().get(row).get(col).setCellState(CellState.FILLED);
    board.getBoard().get(row).get(col).setPlayer(currentPlayer);

    Move finalMove = new Move(currentPlayer, board.getBoard().get(row).get(col));
    this.moves.add(finalMove);

    if (gameWinningStrategy.checkWinner(board, currentPlayer, finalMove.getCell())) {
      gameState = GameState.ENDED;
      winner = currentPlayer;
    } else if (gameWinningStrategy.checkIfDraw(board)) {
      gameState = GameState.DRAW;
    }

    nextPlayerIndex = nextPlayerIndex + 1;
    nextPlayerIndex %= players.size();
  }

  private boolean isValidMove(Move move, Board board) {
    int row = move.getCell().getRow();
    int col = move.getCell().getCol();
    int dimension = board.getBoard().size();

    if (row > dimension - 1 || col > dimension - 1 ||
        board.getBoard().get(row).get(col).getCellState() == CellState.FILLED) {
      System.out.println("Invalid Move. Please enter a valid values.");
      return false;
    }

    return true;
  }

  public static class Builder {
    private int dimension;
    private List<Player> players;
    private GameWinningType gameWinningType;

    public Builder setDimension(int dimension) {
      this.dimension = dimension;
      return this;
    }

    public Builder setPlayers(List<Player> players) {
      this.players = players;
      return this;
    }

    public Builder setGameWinningType(GameWinningType gameWinningType) {
      this.gameWinningType = gameWinningType;
      return this;
    }

    public Game build() {
      Game game = new Game();
      game.setGameState(GameState.IN_PROGRESS);
      game.setBoard(new Board(dimension));
      game.setGameWinningStrategy(GameWinningStrategyFactory.getGameWinningStrategy(gameWinningType, dimension));
      game.setPlayers(players);
      game.setMoves(new ArrayList<>());
      game.setNextPlayerIndex(0);
      return game;
    }

  }


}
