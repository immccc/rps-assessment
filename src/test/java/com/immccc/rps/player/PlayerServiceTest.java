package com.immccc.rps.player;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static com.immccc.rps.player.PlayerAIHandlerType.ALWAYS_ROCK;
import static com.immccc.rps.player.PlayerAIHandlerType.RANDOM;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PlayerServiceTest {

    private static final PlayerAIHandlerType EXISTING_AI_HANDLER_TYPE = RANDOM;
    private static final PlayerAIHandlerType NON_EXISTING_AI_HANDLER_TYPE = ALWAYS_ROCK;
    private static final String PLAYER_NAME = "player name";

    @Spy
    private List<PlayerAIHandler> aiHandlers = new LinkedList<>();

    @Mock
    private PlayerAIHandler aiHandler;

    @InjectMocks
    private PlayerService service;

    @Before
    public void setup() {
        aiHandlers.add(aiHandler);
        doReturn(EXISTING_AI_HANDLER_TYPE).when(aiHandler).getType();
    }

    @Test
    public void makeSelectionSuccessful() {
        Player player = givenAPlayer(EXISTING_AI_HANDLER_TYPE);

        service.makeSelection(player);

        verify(aiHandler).makeSelection();
    }

    @Test(expected = IllegalStateException.class)
    public void makeSelectionFailed() {
        Player player = givenAPlayer(NON_EXISTING_AI_HANDLER_TYPE);

        service.makeSelection(player);
    }

    @Test
    public void createPlayer() {
        Player player = service.createPlayer(PLAYER_NAME, EXISTING_AI_HANDLER_TYPE);
        assertThat(player.getAiHandlerType(), is(EXISTING_AI_HANDLER_TYPE));
    }

    private Player givenAPlayer(PlayerAIHandlerType aiHandlerType) {
        return Player.builder()
                .aiHandlerType(aiHandlerType)
                .build();
    }
}
