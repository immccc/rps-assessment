package com.immccc.rps.player.handler;

import com.immccc.rps.player.PlayerSelectionType;
import org.springframework.stereotype.Service;

import java.util.Random;

import static com.immccc.rps.player.handler.PlayerAIHandlerType.RANDOM;

@Service
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
