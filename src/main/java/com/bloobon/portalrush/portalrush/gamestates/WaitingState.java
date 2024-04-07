package com.bloobon.portalrush.portalrush.gamestates;

import com.bloobon.portalrush.portalrush.managers.game.GameManager;
import org.jetbrains.annotations.NotNull;

public class WaitingState extends GameState {
    public WaitingState(@NotNull GameManager gameManager) {
        super(gameManager);
    }

    @Override
    public void onSet() {
        //Players are waiting in the lobby.
        //TODO retrooper PROHIBIT destruction within the lobby probably
    }
}
