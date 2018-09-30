package com.immccc.rps.stats;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class StatsRepositoryTest {

    private StatsRepository repository;

    @Before
    public void setup() {
        repository = new StatsRepository();
    }

    @Test
    public void getStats() {
        Stats stats = repository.getStats();
        assertThat(stats, notNullValue(Stats.class));
    }

    @Test
    public void updatePlayer1Victories() {
        Stats previousStats = repository.getStats();
        repository.updatePlayer1Victories();
        Stats updatedStats = repository.getStats();

        assertThat(updatedStats.getPlayer1Victories(), is(previousStats.getPlayer1Victories() + 1));
        assertThat(updatedStats.getPlayer2Victories(), is(previousStats.getPlayer2Victories()));
        assertThat(updatedStats.getDraws(), is(previousStats.getDraws()));
        assertThat(updatedStats.getRounds(), is(previousStats.getRounds() + 1));
    }

    @Test
    public void updatePlayer2Victories() {
        Stats previousStats = repository.getStats();
        repository.updatePlayer2Victories();
        Stats updatedStats = repository.getStats();

        assertThat(updatedStats.getPlayer1Victories(), is(previousStats.getPlayer1Victories()));
        assertThat(updatedStats.getPlayer2Victories(), is(previousStats.getPlayer2Victories() + 1));
        assertThat(updatedStats.getDraws(), is(previousStats.getDraws()));
        assertThat(updatedStats.getRounds(), is(previousStats.getRounds() + 1));

    }

    @Test
    public void updateDraws() {
        Stats previousStats = repository.getStats();
        repository.updateDraws();
        Stats updatedStats = repository.getStats();

        assertThat(updatedStats.getPlayer1Victories(), is(previousStats.getPlayer1Victories()));
        assertThat(updatedStats.getPlayer2Victories(), is(previousStats.getPlayer2Victories()));
        assertThat(updatedStats.getDraws(), is(previousStats.getDraws() + 1));
        assertThat(updatedStats.getRounds(), is(previousStats.getRounds() + 1));

    }
}