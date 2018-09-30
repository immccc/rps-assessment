package com.immccc.rps.player.handler;

import com.google.common.collect.ImmutableSet;
import com.immccc.rps.player.PlayerSelectionType;
import org.junit.Test;

import java.util.Set;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.isIn;
import static org.junit.Assert.assertThat;

public class RandomPlayerAIHandlerTest {

    private static final Set<String> ALLOWED_PLAYER_SELECTIONS = ImmutableSet.of("ROCK", "PAPER", "SCISSORS");
    private static final int ATTEMPTS_FOR_TESTING_RANDOMNESS = 10;

    private RandomPlayerAIHandler aiHandler = new RandomPlayerAIHandler();

    @Test
    public void getPlayerSelection() {

        IntStream.of(0, ATTEMPTS_FOR_TESTING_RANDOMNESS).forEach(unused -> {
            PlayerSelectionType playerSelection = aiHandler.makeSelection();
            assertThat(playerSelection.name(), isIn(ALLOWED_PLAYER_SELECTIONS));
        });

    }

}
