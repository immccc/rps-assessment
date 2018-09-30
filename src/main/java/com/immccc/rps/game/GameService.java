package com.immccc.rps.game;

import com.immccc.rps.player.Player;
import com.immccc.rps.player.PlayerService;
import com.immccc.rps.round.Round;
import com.immccc.rps.round.RoundService;
import com.immccc.rps.stats.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.immccc.rps.player.PlayerAIHandlerType.ALWAYS_ROCK;
import static com.immccc.rps.player.PlayerAIHandlerType.RANDOM;

@Service
@RequiredArgsConstructor
class GameService {

    private final PlayerService playerService;
    private final RoundService roundService;
    private final StatsService statsService;

    Game startGame() {

        Player player1 = playerService.createPlayer("Player 1", ALWAYS_ROCK);
        Player player2 = playerService.createPlayer("Player 2", RANDOM);

        return Game.builder()
                .player1(player1)
                .player2(player2)
                .build();
    }

    void makeRound(Game game) {
        Round round = roundService.makeRound(game.getPlayer1(), game.getPlayer2());
        game.getRounds().add(round);

        statsService.updateStats(round, game.getPlayer1(), game.getPlayer2());
    }

}
