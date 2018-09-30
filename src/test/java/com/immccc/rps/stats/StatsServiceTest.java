package com.immccc.rps.stats;

import com.immccc.rps.player.Player;
import com.immccc.rps.player.PlayerSelectionType;
import com.immccc.rps.round.Round;
import com.immccc.rps.round.RoundService;
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

import static com.immccc.rps.player.PlayerSelectionType.SCISSORS;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(JUnitParamsRunner.class)
public class StatsServiceTest {

    private static final PlayerSelectionType PLAYER_SELECTION = SCISSORS;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private StatsRepository statsRepository;

    @Mock
    private RoundService roundService;

    @InjectMocks
    private StatsService service;

    @Test
    @Parameters({
            "true, false",
            "false, true",
            "falase, false"})
    public void updateStats(boolean player1Wins, boolean player2Wins) {
        Round round = givenARound();
        Player player1 = givenAPlayer();
        Player player2 = givenAPlayer();

        givenPlayerWinsRound(player1Wins, player2Wins, player1, player2);

        service.updateStats(round, player1, player2);

        thenStatsIsUpdatedWithWinner(player1Wins, player2Wins);

    }

    private void thenStatsIsUpdatedWithWinner(boolean player1Wins, boolean player2Wins) {
        if (player1Wins) {
            verify(statsRepository).updatePlayer1Victories();
        } else if (player2Wins) {
            verify(statsRepository).updatePlayer2Victories();
        } else {
            verify(statsRepository).updateDraws();
        }
    }

    private void givenPlayerWinsRound(boolean player1Wins, boolean player2Wins, Player player1, Player player2) {
        if (player1Wins) {
            doReturn(Optional.of(player1)).when(roundService).getWinner(eq(player1), eq(player2), any(Round.class));
        } else if (player2Wins) {
            doReturn(Optional.of(player2)).when(roundService).getWinner(eq(player1), eq(player2), any(Round.class));
        } else {
            doReturn(Optional.empty()).when(roundService).getWinner(eq(player1), eq(player2), any(Round.class));
        }
    }

    @Test
    public void getStats() {
        service.getStats();
        verify(statsRepository).getStats();
    }

    private Player givenAPlayer() {
        return Player.builder().build();
    }

    private Round givenARound() {
        return Round.builder()
                .player1Selection(PLAYER_SELECTION)
                .player2Selection(PLAYER_SELECTION)
                .build();
    }
}