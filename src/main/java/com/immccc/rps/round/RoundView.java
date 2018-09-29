package com.immccc.rps.round;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class RoundView {
    private final String player1Selection;
    private final String player2Selection;
    private final String winner;
}
