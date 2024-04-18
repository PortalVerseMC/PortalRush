package com.bloobon.portalrush.portalrush.gamestates;

import com.bloobon.portalrush.portalrush.managers.game.GameManager;
import com.bloobon.portalrush.portalrush.tasks.DiamondUpgrade;
import org.jetbrains.annotations.NotNull;

public class DiamondUpgradeState extends GameState {

    private final int seconds;

    public DiamondUpgradeState(@NotNull GameManager gameManager, int seconds) {
        super(gameManager);
        this.seconds = seconds;
    }

    @Override
    public void onSet() {
        new DiamondUpgrade(1, 2, seconds, gameManager).start();
    }
}
