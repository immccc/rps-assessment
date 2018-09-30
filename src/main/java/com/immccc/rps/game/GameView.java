package com.immccc.rps.game;

import com.immccc.rps.player.Player;
import com.immccc.rps.round.RoundMapper;
import com.immccc.rps.round.RoundService;
import com.immccc.rps.round.RoundView;
import lombok.Getter;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PACKAGE;

@Named("game")
@ViewScoped
public class GameView {

    private static final String DRAW_MESSAGE = "DRAW";

    private final GameService gameService;
    private final RoundService roundService;

    @Getter(PACKAGE)
    private Game game;

    @Getter
    private String player1;
    @Getter
    private String player2;

    public GameView(GameService gameService, RoundService roundService) {
        this.gameService = gameService;
        this.roundService = roundService;
        startNewGame();
    }

    public List<RoundView> getRounds() {
        return game.getRounds().stream()
                .map(round -> RoundMapper.toRoundView(round,
                        roundService.getWinner(game.getPlayer1(), game.getPlayer2(), round)
                                .map(Player::getName)
                                .orElse(DRAW_MESSAGE)))
                .collect(Collectors.toList());
    }

    public int getNumberOfRounds() {
        return game.getRounds().size();
    }

    public void makeRound() {
        gameService.makeRound(game);
    }

    public void startNewGame() {
        game = gameService.startGame();
        player1 = game.getPlayer1().getName();
        player2 = game.getPlayer2().getName();
    }

}
