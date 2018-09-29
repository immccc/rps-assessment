package com.immccc.rps.game;

import com.immccc.rps.player.Player;
import com.immccc.rps.player.PlayerSelectionType;
import com.immccc.rps.player.PlayerService;
import com.immccc.rps.round.Round;
import com.immccc.rps.round.RoundService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.immccc.rps.player.PlayerAIHandlerType.ALWAYS_ROCK;
import static com.immccc.rps.player.PlayerAIHandlerType.RANDOM;
import static com.immccc.rps.player.PlayerSelectionType.SCISSORS;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

    private static final PlayerSelectionType PLAYER_SELECTION = SCISSORS;

    @Mock
    private PlayerService playerService;

    @Mock
    private RoundService roundService;

    @InjectMocks
    private GameService gameService;

    @Test
    public void createGame() {

        Game game = gameService.startGame();

        verify(playerService).createPlayer("Player 1", ALWAYS_ROCK);
        verify(playerService).createPlayer("Player 2", RANDOM);

        assertThat(game.getRounds(), empty());
    }

    @Test
    public void playRound() {

        Game game = givenAGame();
        Round round = givenAGameRound(game);

        gameService.makeRound(game);

        assertThat(game.getRounds(), contains(round));
    }

    private Round givenAGameRound(Game game) {

        Round round = Round.builder()
                .player1Selection(PLAYER_SELECTION)
                .player2Selection(PLAYER_SELECTION)
                .build();

        doReturn(round).when(roundService).makeRound(game.getPlayer1(), game.getPlayer2());
        return round;
    }

    private Game givenAGame() {

        return Game.builder()
                .player1(Player.builder().build())
                .player2(Player.builder().build())
                .build();
    }

}
