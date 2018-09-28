package com.immccc.rps.game;

import com.immccc.rps.player.PlayerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.immccc.rps.player.PlayerAIHandlerType.ALWAYS_ROCK;
import static com.immccc.rps.player.PlayerAIHandlerType.RANDOM;
import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

    @Mock
    private PlayerService playerService;

    @InjectMocks
    private GameService gameService;

    @Test
    public void createGame() {

        Game game = gameService.startGame();

        verify(playerService).createPlayer(ALWAYS_ROCK);
        verify(playerService).createPlayer(RANDOM);

        assertThat(game.getRounds(), empty());

    }

}