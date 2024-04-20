package com.bloobon.portalrush.portalrush.gamestates;

import com.bloobon.portalrush.portalrush.managers.game.GameManager;
import com.bloobon.portalrush.portalrush.tasks.EmeraldUpgrade;
import org.jetbrains.annotations.NotNull;

public class EmeraldUpgradeState extends GameState {

    private final int seconds;

    public EmeraldUpgradeState(@NotNull GameManager gameManager, int seconds) {
        super(gameManager);
        this.seconds = seconds;
    }

    @Override
    public void onSet() {
        new EmeraldUpgrade(1, 2, seconds, gameManager).start();
    }
}
