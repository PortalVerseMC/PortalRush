package com.bloobon.portalrush.portalrush.managers.states;

import com.bloobon.portalrush.portalrush.gamestates.GameState;
import com.bloobon.portalrush.portalrush.managers.game.GameManager;
import org.jetbrains.annotations.NotNull;

public class StateManager {

    private final GameManager gameManager;

    public StateManager(@NotNull GameManager gameManager){
        this.gameManager = gameManager;
    }

    public void changeState(@NotNull GameState state){
        gameManager.setState(state);
        state.onSet();
    }
}
