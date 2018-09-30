package com.immccc.rps.stats;

import com.immccc.rps.player.Player;
import com.immccc.rps.round.Round;
import com.immccc.rps.round.RoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StatsService {

    private final StatsRepository statsRepository;

    private final RoundService roundService;

    public void updateStats(Round round, Player player1, Player player2) {
        Optional<Player> winner = roundService.getWinner(player1, player2, round);

        if (!winner.isPresent()) {
            statsRepository.updateDraws();
        } else {
            winner.map(playerWinner -> playerWinner == player1)
                    .ifPresent(this::updatePlayerVictory);
        }

    }

    Stats getStats() {
        return statsRepository.getStats();
    }

    private void updatePlayerVictory(boolean player1Wins) {
        if (player1Wins) {
            statsRepository.updatePlayer1Victories();
        } else {
            statsRepository.updatePlayer2Victories();
        }
    }

}
