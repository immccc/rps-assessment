package com.immccc.rps.player.handler;

import com.immccc.rps.player.PlayerSelectionType;
import org.springframework.stereotype.Service;

import static com.immccc.rps.player.PlayerSelectionType.ROCK;
import static com.immccc.rps.player.handler.PlayerAIHandlerType.ALWAYS_ROCK;

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
