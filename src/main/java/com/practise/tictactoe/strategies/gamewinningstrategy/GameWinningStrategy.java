package com.practise.tictactoe.strategies.gamewinningstrategy;

import com.practise.tictactoe.models.Board;
import com.practise.tictactoe.models.Cell;
import com.practise.tictactoe.models.Player;

public interface GameWinningStrategy {

  boolean checkWinner(Board board, Player lastMovePlayer, Cell moveCell);

  boolean checkIfDraw(Board board);
  
}
