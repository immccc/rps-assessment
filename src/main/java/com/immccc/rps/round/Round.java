package com.immccc.rps.round;

import com.immccc.rps.player.PlayerSelectionType;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class Round {
    private final PlayerSelectionType player1Selection;
    private final PlayerSelectionType player2Selection;
}
