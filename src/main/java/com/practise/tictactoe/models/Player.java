package com.practise.tictactoe.models;

import java.util.Scanner;

public class Player {

  private String name;
  private char symbol;
  private PlayerType playerType;

  public Player(String name, char symbol, PlayerType playerType) {
    this.name = name;
    this.symbol = symbol;
    this.playerType = playerType;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public char getSymbol() {
    return symbol;
  }

  public void setSymbol(char symbol) {
    this.symbol = symbol;
  }

  public PlayerType getPlayerType() {
    return playerType;
  }

  public void setPlayerType(PlayerType playerType) {
    this.playerType = playerType;
  }

  public Move decideMove(Player player, Board board) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter row starting with 0 index: ");
    int row = scanner.nextInt();

    System.out.print("Enter column starting with 0 index: ");
    int col = scanner.nextInt();

    return new Move(player, new Cell(row, col));
  }
}
