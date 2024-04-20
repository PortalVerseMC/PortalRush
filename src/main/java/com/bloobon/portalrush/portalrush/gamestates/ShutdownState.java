package com.bloobon.portalrush.portalrush.gamestates;

import com.bloobon.portalrush.portalrush.managers.game.GameManager;
import org.jetbrains.annotations.NotNull;

public class ShutdownState extends GameState {
    public ShutdownState(@NotNull GameManager gameManager) {
        super(gameManager);
    }

    @Override
    public void onSet() {
        //TODO Shutdown logic
    }
}
