package com.immccc.rps.player;

public interface PlayerAIHandler {
    PlayerAIHandlerType getType();

    PlayerSelectionType makeSelection();
}
