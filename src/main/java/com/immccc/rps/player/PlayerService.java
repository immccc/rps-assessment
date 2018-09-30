package com.immccc.rps.player;

import com.immccc.rps.player.handler.PlayerAIHandler;
import com.immccc.rps.player.handler.PlayerAIHandlerType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final List<PlayerAIHandler> aiHandlers;

    public PlayerSelectionType makeSelection(Player player) {
        PlayerAIHandler handler = getPlayerAIHandler(player);
        return handler.makeSelection();
    }

    private PlayerAIHandler getPlayerAIHandler(Player player) {
        return aiHandlers.stream()
                .filter(candidateHandler -> candidateHandler.getType().equals(player.getAiHandlerType()))
                .findFirst().orElseThrow(() -> new IllegalStateException(
                        String.format("Player handler of type %s has not been defined", player.getAiHandlerType())));
    }

    public Player createPlayer(String name, PlayerAIHandlerType aiHandlerType) {
        return Player.builder()
                .name(name)
                .aiHandlerType(aiHandlerType)
                .build();
    }
}
