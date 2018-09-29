package com.immccc.rps.player;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class PlayerMapperTest {

    private static final String PLAYER_NAME = "Player 1";

    @Test
    public void toPlayerView() {
        Player player = givenAPlayer();
        PlayerView playerView = PlayerMapper.toPlayerView(player);

        Assert.assertThat(playerView.getName(), is(player.getName()));
    }

    private Player givenAPlayer() {
        return Player.builder()
                .name(PLAYER_NAME)
                .build();
    }
}
