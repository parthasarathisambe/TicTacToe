package com.practise.tictactoe.strategies.botplayingstrategy;

import com.practise.tictactoe.models.Board;
import com.practise.tictactoe.models.Move;
import com.practise.tictactoe.models.Player;

public interface BotPlayingStrategy {

  Move decideMove(Player player, Board board);

}
