package com.immccc.rps.player;

import java.util.Random;

import static com.immccc.rps.player.PlayerAIHandlerType.RANDOM;

class RandomPlayerAIHandler implements PlayerAIHandler {
    private static final Random random = new Random();

    @Override
    public PlayerAIHandlerType getType() {
        return RANDOM;
    }

    @Override
    public PlayerSelectionType makeSelection() {
        int value = random.nextInt(PlayerSelectionType.values().length);
        return PlayerSelectionType.values()[value];

    }
}
