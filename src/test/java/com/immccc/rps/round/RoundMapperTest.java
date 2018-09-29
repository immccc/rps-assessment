package com.immccc.rps.round;

import com.immccc.rps.player.PlayerSelectionType;
import org.junit.Test;

import static com.immccc.rps.player.PlayerSelectionType.SCISSORS;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RoundMapperTest {

    private static final PlayerSelectionType PLAYER_SELECTION = SCISSORS;
    private static final String WINNER_NAME = "winner";

    @Test
    public void toRoundView() {

        Round round = givenARound();

        RoundView roundView = RoundMapper.toRoundView(round, WINNER_NAME);

        assertThat(roundView.getPlayer1Selection(), is(round.getPlayer1Selection().name()));
        assertThat(roundView.getPlayer2Selection(), is(round.getPlayer2Selection().name()));
        assertThat(roundView.getWinner(), is(WINNER_NAME));
    }

    private Round givenARound() {
        return Round.builder()
                .player1Selection(PLAYER_SELECTION)
                .player2Selection(PLAYER_SELECTION)
                .build();
    }
}
