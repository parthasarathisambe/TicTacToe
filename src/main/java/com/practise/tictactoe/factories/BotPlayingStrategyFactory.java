package com.practise.tictactoe.factories;

import com.practise.tictactoe.models.BotDifficultyLevel;
import com.practise.tictactoe.strategies.botplayingstrategy.BotPlayingStrategy;
import com.practise.tictactoe.strategies.botplayingstrategy.BotPlayingWithEasyStrategy;
import com.practise.tictactoe.strategies.botplayingstrategy.BotPlayingWithHardStrategy;
import com.practise.tictactoe.strategies.botplayingstrategy.BotPlayingWithMediumStrategy;

public class BotPlayingStrategyFactory {

  private BotPlayingStrategyFactory() {

  }

  public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel) {
    if (botDifficultyLevel == BotDifficultyLevel.HARD) {
      return new BotPlayingWithHardStrategy();
    } else if (botDifficultyLevel == BotDifficultyLevel.MEDIUM) {
      return new BotPlayingWithMediumStrategy();
    } else {
      return new BotPlayingWithEasyStrategy();
    }
  }

}
