package com.immccc.rps.player;

import org.springframework.stereotype.Service;

import static com.immccc.rps.player.PlayerAIHandlerType.ALWAYS_ROCK;
import static com.immccc.rps.player.PlayerSelectionType.ROCK;

@Service
class AlwaysRockPlayerAIHandler implements PlayerAIHandler {

    @Override
    public PlayerAIHandlerType getType() {
        return ALWAYS_ROCK;
    }

    @Override
    public PlayerSelectionType makeSelection() {
        return ROCK;
    }
}
