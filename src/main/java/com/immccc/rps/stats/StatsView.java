package com.immccc.rps.stats;

import lombok.Getter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import static lombok.AccessLevel.PACKAGE;

@Named("stats")
@ApplicationScoped
public class StatsView {
    private static final int DEFAULT_REFRESH_INTERVAL = 1;

    private final StatsService statsService;

    @Getter
    private final int refreshInterval;

    @Getter(PACKAGE)
    private Stats stats;

    public StatsView(StatsService statsService) {
        this.statsService = statsService;
        this.stats = this.statsService.getStats();
        this.refreshInterval = DEFAULT_REFRESH_INTERVAL;
    }

    public int getPlayer1Victories() {
        return stats.getPlayer1Victories();
    }

    public int getPlayer2Victories() {
        return stats.getPlayer2Victories();
    }

    public int getDraws() {
        return stats.getDraws();
    }

    public int getRounds() {
        return stats.getRounds();
    }

    public void refresh() {
        stats = statsService.getStats();
    }
}
