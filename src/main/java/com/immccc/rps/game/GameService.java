package com.immccc.rps.game;

import com.immccc.rps.player.Player;
import com.immccc.rps.player.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.immccc.rps.player.PlayerAIHandlerType.ALWAYS_ROCK;
import static com.immccc.rps.player.PlayerAIHandlerType.RANDOM;

@Service
@RequiredArgsConstructor
public class GameService {

    private final PlayerService playerService;

    public Game startGame() {

        Player player1 = playerService.createPlayer(ALWAYS_ROCK);
        Player player2 = playerService.createPlayer(RANDOM);

        return Game.builder()
                .player1(player1)
                .player2(player2)
                .build();
    }

}
