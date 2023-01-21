package com.practise.tictactoe.strategies.botplayingstrategy;

import com.practise.tictactoe.models.Board;
import com.practise.tictactoe.models.Cell;
import com.practise.tictactoe.models.CellState;
import com.practise.tictactoe.models.Move;
import com.practise.tictactoe.models.Player;

public class BotPlayingWithEasyStrategy implements BotPlayingStrategy {

  @Override
  public Move decideMove(Player player, Board board) {
    int dimension = board.getBoard().size();
    for (int i = 0; i < dimension; i++) {
      for (int j = 0; j < dimension; j++) {
        if (board.getBoard().get(i).get(j).getCellState() == CellState.EMPTY) {
          return new Move(player, new Cell(i, j));
        }
      }
    }
    return null;
  }

}
