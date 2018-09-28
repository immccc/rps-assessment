package com.immccc.rps.game;

import com.immccc.rps.player.Player;
import com.immccc.rps.round.Round;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Builder
public class Game {
    private final List<Round> rounds = new LinkedList<>();
    private final Player player1;
    private final Player player2;
}
