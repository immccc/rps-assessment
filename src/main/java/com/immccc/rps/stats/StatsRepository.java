package com.immccc.rps.stats;

import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicInteger;

@Repository
class StatsRepository {
    private final AtomicInteger player1Victories = new AtomicInteger();
    private final AtomicInteger player2Victories = new AtomicInteger();
    private final AtomicInteger draws = new AtomicInteger();
    private final AtomicInteger rounds = new AtomicInteger();

    Stats getStats() {
        return Stats.builder()
                .player1Victories(player1Victories.get())
                .player2Victories(player2Victories.get())
                .draws(draws.get())
                .rounds(rounds.get())
                .build();
    }

    void updatePlayer1Victories() {
        player1Victories.getAndIncrement();
        rounds.getAndIncrement();
    }

    void updatePlayer2Victories() {
        player2Victories.getAndIncrement();
        rounds.getAndIncrement();
    }

    void updateDraws() {
        draws.getAndIncrement();
        rounds.getAndIncrement();
    }
}
