package com.immccc.rps.player;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class PlayerView {
    private final String name;
}
