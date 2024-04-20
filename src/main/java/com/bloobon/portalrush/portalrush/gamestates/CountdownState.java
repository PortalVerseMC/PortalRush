package com.bloobon.portalrush.portalrush.gamestates;

import com.bloobon.portalrush.portalrush.managers.game.GameManager;
import com.bloobon.portalrush.portalrush.tasks.Countdown;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CountdownState extends GameState {

    private final int seconds;
    private final @Nullable BukkitRunnable secondaryTask;

    public CountdownState(@NotNull GameManager gameManager, int seconds, @Nullable BukkitRunnable secondaryTask) {
        super(gameManager);
        this.seconds = seconds;
        this.secondaryTask = secondaryTask;
    }

    @Override
    public void onSet() {
        new Countdown(seconds, gameManager, secondaryTask).start();
    }
}
