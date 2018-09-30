package com.immccc.rps.player.handler;

import com.immccc.rps.player.PlayerSelectionType;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AlwaysRockPlayerAIHandlerTest {

    private static final String EXPECTED_FIXED_PLAYER_SELECTION = "ROCK";
    private AlwaysRockPlayerAIHandler aiHandler = new AlwaysRockPlayerAIHandler();

    @Test
    public void getPlayerSelection() {

        PlayerSelectionType playerSelection = aiHandler.makeSelection();
        assertThat(playerSelection.name(), is(EXPECTED_FIXED_PLAYER_SELECTION));
    }

}
