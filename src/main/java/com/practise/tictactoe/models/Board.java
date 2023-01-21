package com.practise.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

  private List<List<Cell>> board;

  public Board(int dimension) {
    this.board = new ArrayList<>();

    for (int i = 0; i < dimension; i++) {
      this.board.add(new ArrayList<>());
      for (int j = 0; j < dimension; j++) {
        this.board.get(i).add(new Cell(i, j));
      }
    }

  }

  public List<List<Cell>> getBoard() {
    return this.board;
  }

  public void displayBoard() {
    int dimension = board.size();
    for (List<Cell> cells : board) {
      System.out.print("|");
      for (int j = 0; j < dimension; j++) {
        Cell cell = cells.get(j);
        if (cell.getCellState() == CellState.EMPTY) {
          System.out.print("     |");
        } else {
          System.out.print("  " + cells.get(j).getPlayer().getSymbol() + "  |");
        }
      }
      System.out.println();
    }
  }


}
