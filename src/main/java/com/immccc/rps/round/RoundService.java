package com.immccc.rps.round;

import com.immccc.rps.player.Player;
import com.immccc.rps.player.PlayerSelectionType;
import com.immccc.rps.player.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.immccc.rps.player.PlayerSelectionType.*;

@Service
@RequiredArgsConstructor
public class RoundService {

    private final PlayerService playerService;

    public Round makeRound(Player player1, Player player2) {
        PlayerSelectionType player1Selection = playerService.makeSelection(player1);
        PlayerSelectionType player2Selection = playerService.makeSelection(player2);

        return Round.builder()
                .player1Selection(player1Selection)
                .player2Selection(player2Selection)
                .build();
    }

    public Optional<Player> getWinner(Player player1, Player player2, Round round) {

        PlayerSelectionType selectionPlayer1 = round.getPlayer1Selection();
        PlayerSelectionType selectionPlayer2 = round.getPlayer2Selection();

        if (selectionPlayer1.equals(selectionPlayer2)) {
            return Optional.empty();
        }

        switch (selectionPlayer1) {
            case ROCK:
                return Optional.of(selectionPlayer2.equals(SCISSORS) ? player1 : player2);
            case SCISSORS:
                return Optional.of(selectionPlayer2.equals(PAPER) ? player1 : player2);
            case PAPER:
                return Optional.of(selectionPlayer2.equals(ROCK) ? player1 : player2);
            default:
                throw new IllegalArgumentException(String.format("Invalid selection %s to compare", selectionPlayer1));
        }

    }
}
