package com.immccc.rps.player;

import java.util.Random;

import static com.immccc.rps.player.PlayerAIHandlerType.ALWAYS_ROCK;
import static com.immccc.rps.player.PlayerSelectionType.ROCK;

class AlwaysRockPlayerAIHandler implements PlayerAIHandler {
    private static final Random random = new Random();

    @Override
    public PlayerAIHandlerType getType() {
        return ALWAYS_ROCK;
    }

    @Override
    public PlayerSelectionType makeSelection() {
        return ROCK;
    }
}
