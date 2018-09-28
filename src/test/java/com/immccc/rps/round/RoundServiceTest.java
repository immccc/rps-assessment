package com.immccc.rps.round;

import com.immccc.rps.player.Player;
import com.immccc.rps.player.PlayerSelectionType;
import com.immccc.rps.player.PlayerService;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Optional;

import static com.immccc.rps.player.PlayerSelectionType.ROCK;
import static com.immccc.rps.player.PlayerSelectionType.SCISSORS;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(JUnitParamsRunner.class)
public class RoundServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private PlayerService playerService;

    @InjectMocks
    private RoundService service;

    @Test
    public void makeRound() {
        Player player1 = givenAPlayer();
        Player player2 = givenAPlayer();

        PlayerSelectionType player1Selection = ROCK;
        PlayerSelectionType player2Selection = SCISSORS;

        givenPlayerSelects(player1, player1Selection);
        givenPlayerSelects(player2, player2Selection);

        Round round = service.makeRound(player1, player2);

        assertThat(round.getPlayer1Selection(), is(player1Selection));
        assertThat(round.getPlayer2Selection(), is(player2Selection));
    }

    @Test
    @Parameters({
            "ROCK, SCISSORS, true, false",
            "SCISSORS, ROCK, false, true",
            "PAPER, ROCK, true, false",
            "ROCK, PAPER, false, true",
            "SCISSORS, PAPER, true, false",
            "PAPER, SCISSORS, false, true",
            "ROCK, ROCK, false, false",
            "SCISSORS, SCISSORS, false, false",
            "PAPER, PAPER, false, false"})
    public void getWinner(PlayerSelectionType player1Selection, PlayerSelectionType player2Selection,
                          boolean expectedPlayer1Wins, boolean expectedPlayer2Wins) {

        Player player1 = givenAPlayer();
        Player player2 = givenAPlayer();

        Round round = Round.builder()
                .player1Selection(player1Selection)
                .player2Selection(player2Selection)
                .build();

        Optional<Player> winner = service.getWinner(player1, player2, round);

        if (!expectedPlayer1Wins && !expectedPlayer2Wins) {
            assertThat(winner.isPresent(), is(false));
        } else {
            Player winnerFound = winner.orElseThrow(
                    () -> new IllegalStateException("No player found, but it´s expected to be present"));

            if (expectedPlayer1Wins) {
                verifyPlayersWinningStatus(winnerFound, player1, player2);
            }
            if (expectedPlayer2Wins) {
                verifyPlayersWinningStatus(winnerFound, player2, player1);
            }
        }

    }

    private void verifyPlayersWinningStatus(Player actualWinner, Player expectedWinner, Player expectedLoser) {
        assertThat(actualWinner, is(expectedWinner));
        assertThat(actualWinner, not(is(expectedLoser)));
    }


    private void givenPlayerSelects(Player player, PlayerSelectionType selection) {
        doReturn(selection).when(playerService).makeSelection(player);
    }

    private Player givenAPlayer() {
        return Player.builder()
                .build();
    }
}
