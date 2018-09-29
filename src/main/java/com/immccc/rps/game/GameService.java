package com.immccc.rps.game;

import com.immccc.rps.player.Player;
import com.immccc.rps.player.PlayerService;
import com.immccc.rps.round.Round;
import com.immccc.rps.round.RoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.immccc.rps.player.PlayerAIHandlerType.ALWAYS_ROCK;
import static com.immccc.rps.player.PlayerAIHandlerType.RANDOM;

@Service
@RequiredArgsConstructor
public class GameService {

    private final PlayerService playerService;
    private final RoundService roundService;

    public Game startGame() {

        Player player1 = playerService.createPlayer("Player 1", ALWAYS_ROCK);
        Player player2 = playerService.createPlayer("Player 2", RANDOM);

        return Game.builder()
                .player1(player1)
                .player2(player2)
                .build();
    }

    public void makeRound(Game game) {
        Round round = roundService.makeRound(game.getPlayer1(), game.getPlayer2());
        game.getRounds().add(round);
    }

}
