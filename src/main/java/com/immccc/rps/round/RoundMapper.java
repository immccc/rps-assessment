package com.immccc.rps.round;

public class RoundMapper {

    public static RoundView toRoundView(Round round, String winnerName) {
        return RoundView.builder()
                .player1Selection(round.getPlayer1Selection().name())
                .player2Selection(round.getPlayer2Selection().name())
                .winner(winnerName)
                .build();
    }
}
