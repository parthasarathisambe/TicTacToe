package com.practise.tictactoe.strategies.gamewinningstrategy;

import com.practise.tictactoe.models.Board;
import com.practise.tictactoe.models.Cell;
import com.practise.tictactoe.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RowColWinningStrategy implements GameWinningStrategy {

  List<Map<Character, Integer>> rowSymbolCounts = new ArrayList<>();
  List<HashMap<Character, Integer>> colSymbolCounts = new ArrayList<>();

  public RowColWinningStrategy(int dimension) {
    for (int i = 0; i < dimension; i++) {
      rowSymbolCounts.add(new HashMap<>());
      colSymbolCounts.add(new HashMap<>());
    }
  }

  @Override
  public boolean checkWinner(Board board, Player currentPlayer, Cell currentCell) {
    int row = currentCell.getRow();
    int col = currentCell.getCol();
    char symbol = currentPlayer.getSymbol();
    int dimension = board.getBoard().size();

    rowSymbolCounts.get(row).put(symbol, rowSymbolCounts.get(row).getOrDefault(symbol, 0) + 1);
    colSymbolCounts.get(col).put(symbol, colSymbolCounts.get(col).getOrDefault(symbol, 0) + 1);

    return rowSymbolCounts.get(row).get(symbol) == dimension || colSymbolCounts.get(col).get(symbol) == dimension;
  }

  @Override
  public boolean checkIfDraw(Board board) {
    int dimension = board.getBoard().size();
    int totalCellsFilled = 0;
    for (int i = 0; i < dimension; i++) {
      Map<Character, Integer> rowMap = rowSymbolCounts.get(i);
      for (Integer value : rowMap.values()) {
        totalCellsFilled += value;
      }
    }
    return totalCellsFilled == dimension * dimension;
  }

}
