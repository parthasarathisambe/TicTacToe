package com.practise.tictactoe.factories;

import com.practise.tictactoe.models.GameWinningType;
import com.practise.tictactoe.strategies.gamewinningstrategy.GameWinningStrategy;
import com.practise.tictactoe.strategies.gamewinningstrategy.RowColDiagWinningStrategy;
import com.practise.tictactoe.strategies.gamewinningstrategy.RowColWinningStrategy;

public class GameWinningStrategyFactory {

  private GameWinningStrategyFactory() {

  }

  public static GameWinningStrategy getGameWinningStrategy(GameWinningType gameWinningType, int dimension) {
    if (gameWinningType == GameWinningType.ROW_COL) {
      return new RowColWinningStrategy(dimension);
    } else {
      return new RowColDiagWinningStrategy(dimension);
    }
  }

}
