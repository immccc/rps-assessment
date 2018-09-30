package com.immccc.rps.stats;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
class Stats {
    private final int player1Victories;
    private final int player2Victories;
    private final int draws;
    private final int rounds;
}
