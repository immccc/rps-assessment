package com.immccc.rps.stats;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatsViewTest {

    private static final int DEFAULT_REFRESH_INTERVAL = 1;
    @Mock
    private StatsService statsService;

    private StatsView view;

    @Before
    public void setup() {

        givenStats();
        view = new StatsView(statsService);
    }

    @Test
    public void viewHasBeenInitialized() {
        assertThat(view.getStats(), notNullValue());
        assertThat(view.getRefreshInterval(), is(DEFAULT_REFRESH_INTERVAL));
    }

    @Test
    public void getPlayer1Victories() {
        int player1Victories = view.getPlayer1Victories();
        assertThat(player1Victories, is(view.getStats().getPlayer1Victories()));
    }

    @Test
    public void getPlayer2Victories() {
        int player2Victories = view.getPlayer2Victories();
        assertThat(player2Victories, is(view.getStats().getPlayer2Victories()));
    }

    public void getDraws() {
        int draws = view.getDraws();
        assertThat(draws, is(view.getStats().getDraws()));
    }

    public void getRounds() {
        int rounds = view.getRounds();
        assertThat(rounds, is(view.getStats().getRounds()));
    }

    public void refresh() {
        Stats previousStats = view.getStats();
        view.refresh();
        Stats currentStats = view.getStats();

        verify(statsService).getStats();
        assertThat(currentStats, not(is(previousStats)));
    }

    private void givenStats() {
        Stats stats = Stats.builder()
                .player1Victories(0)
                .player2Victories(0)
                .draws(0)
                .rounds(0)
                .build();

        doReturn(stats).when(statsService).getStats();
    }

}