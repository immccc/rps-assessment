package com.immccc.rps.player;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class Player {
    private final String name;
    private final PlayerAIHandlerType aiHandlerType;
}
