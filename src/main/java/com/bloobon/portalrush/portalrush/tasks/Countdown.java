package com.bloobon.portalrush.portalrush.tasks;

import com.bloobon.portalrush.portalrush.gamestates.LiveState;
import com.bloobon.portalrush.portalrush.PortalRush;
import com.bloobon.portalrush.portalrush.managers.game.GameManager;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.scheduler.BukkitRunnable;
@AllArgsConstructor
public class Countdown extends BukkitRunnable {

    @Getter
    private int seconds;
    private final GameManager gameManager;

    @Override
    public void run() {
        if(seconds == 0){
            //TODO setup event that handles cancellation of Countdown
            cancel();
            gameManager.getStateManager().changeState(new LiveState(gameManager));
            return;
        }
        seconds--;
    }

    public void start(){
        this.runTaskTimerAsynchronously(PortalRush.getInstance(), 20, 20);
    }
}
