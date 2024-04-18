package com.bloobon.portalrush.portalrush.gamestates;

import com.bloobon.portalrush.portalrush.managers.game.GameManager;
import com.bloobon.portalrush.portalrush.tasks.CrystalDie;
import org.jetbrains.annotations.NotNull;

public class CrystalDieState extends GameState {
    private final int seconds;

    public CrystalDieState(@NotNull GameManager gameManager, int seconds) {
        super(gameManager);
        this.seconds = seconds;
    }

    @Override
    public void onSet() {
        new CrystalDie(seconds, gameManager).start();
    }
}
