package com.bloobon.portalrush.portalrush.tasks;

import com.bloobon.portalrush.portalrush.gamestates.LiveState;
import com.bloobon.portalrush.portalrush.PortalRush;
import com.bloobon.portalrush.portalrush.managers.game.GameManager;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.Nullable;

public class Countdown extends BukkitRunnable {

    @Getter
    protected int seconds;
    protected final GameManager gameManager;
    @Nullable private final BukkitRunnable secondaryTask;

    public Countdown(int seconds, GameManager gameManager, @Nullable BukkitRunnable secondaryTask) {
        this.seconds = seconds;
        this.gameManager = gameManager;
        this.secondaryTask = secondaryTask;
    }

    @Override
    public void run() {
        if(seconds == 0){
            //TODO setup event that handles cancellation of Countdown
            cancel();
            if (secondaryTask != null) {
                secondaryTask.run();
            }
            return;
        }
        seconds--;
    }

    public void start(){
        //TODO retrooper not sure why a delay was added here by someone?
        //TODO retrooper is there a reason why a fixed delay was added to every countdown?
        this.runTaskTimerAsynchronously(PortalRush.getInstance(), 20, 20L * seconds);
    }
}
