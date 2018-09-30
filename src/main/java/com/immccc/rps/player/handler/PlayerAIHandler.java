package com.immccc.rps.player.handler;

import com.immccc.rps.player.PlayerSelectionType;

public interface PlayerAIHandler {
    PlayerAIHandlerType getType();
    PlayerSelectionType makeSelection();
}
