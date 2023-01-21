package com.practise.tictactoe.models;

import com.practise.tictactoe.factories.BotPlayingStrategyFactory;
import com.practise.tictactoe.strategies.botplayingstrategy.BotPlayingStrategy;

public class Bot extends Player {

  private BotDifficultyLevel botDifficultyLevel;
  private BotPlayingStrategy botPlayingStrategy;

  public Bot(String name, char symbol, BotDifficultyLevel botDifficultyLevel) {
    super(name, symbol, PlayerType.BOT);
    this.setBotDifficultyLevel(botDifficultyLevel);
    this.setBotPlayingStrategy(BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel));
  }

  @Override
  public Move decideMove(Player player, Board board) {
    return botPlayingStrategy.decideMove(player, board);
  }

  public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
    this.botDifficultyLevel = botDifficultyLevel;
  }

  public void setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
    this.botPlayingStrategy = botPlayingStrategy;
  }

}
