package com.immccc.rps.player;

public class PlayerMapper {

    public static PlayerView toPlayerView(Player player) {
        return PlayerView.builder()
                .name(player.getName())
                .build();
    }
}
