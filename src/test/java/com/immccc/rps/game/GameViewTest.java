package com.immccc.rps.game;

import com.immccc.rps.player.Player;
import com.immccc.rps.player.PlayerSelectionType;
import com.immccc.rps.round.Round;
import com.immccc.rps.round.RoundService;
import com.immccc.rps.round.RoundView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.immccc.rps.player.PlayerSelectionType.SCISSORS;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GameViewTest {

    private static final String PLAYER_1_NAME = "Player 1";
    private static final String PLAYER_2_NAME = "Player 2";
    private static final PlayerSelectionType PLAYER_SELECTION = SCISSORS;

    @Mock
    private RoundService roundService;

    @Mock
    private GameService gameService;

    private GameView view;

    @Before
    public void setup() {
        givenAGame();

        view = new GameView(gameService, roundService);
        assertThat(view.getGame(), notNullValue(Game.class));
    }

    @Test
    public void getRounds() {
        givenARoundInGame();

        Game game = view.getGame();
        List<Round> roundsInGame = game.getRounds();

        List<RoundView> roundViews = view.getRounds();

        assertThat(roundsInGame, hasSize(roundViews.size()));
        verify(roundService, times(roundsInGame.size())).getWinner(eq(game.getPlayer1()), eq(game.getPlayer2()),
                any(Round.class));
    }

    @Test
    public void makeRound() {
        view.makeRound();

        Game game = view.getGame();
        verify(gameService).makeRound(game);
    }

    @Test
    public void startNewGame() {
        Game previousGame = view.getGame();

        givenAGame();
        view.startNewGame();

        Game newGame = view.getGame();
        assertThat(newGame, not(is(previousGame)));
    }

    private void givenAGame() {
        Game game = Game.builder()
                .player1(givenAPlayer(PLAYER_1_NAME))
                .player2(givenAPlayer(PLAYER_2_NAME))
                .build();

        doReturn(game).when(gameService).startGame();
    }

    private Player givenAPlayer(String name) {
        return Player.builder()
                .name(name)
                .build();
    }

    private void givenARoundInGame() {
        Round round = Round.builder()
                .player1Selection(PLAYER_SELECTION)
                .player2Selection(PLAYER_SELECTION)
                .build();

        view.getGame().getRounds().add(round);
    }

}