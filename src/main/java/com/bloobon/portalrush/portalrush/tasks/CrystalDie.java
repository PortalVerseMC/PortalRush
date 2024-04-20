package com.bloobon.portalrush.portalrush.tasks;

import com.bloobon.portalrush.portalrush.PortalRush;
import com.bloobon.portalrush.portalrush.gamestates.CountdownState;
import com.bloobon.portalrush.portalrush.gamestates.ShutdownState;
import com.bloobon.portalrush.portalrush.managers.game.GameManager;
import com.bloobon.portalrush.portalrush.managers.players.PlayerManager;
import org.bukkit.scheduler.BukkitRunnable;

public class CrystalDie extends Countdown {

    public CrystalDie(int seconds, GameManager gameManager) {
        super(seconds, gameManager, new BukkitRunnable() {
            @Override
            public void run() {
                //Once all crystals have died, schedule a game end
                gameManager.getStateManager().changeState(
                        new CountdownState(gameManager, PlayerManager.END_GAME, new BukkitRunnable() {
                            @Override
                            public void run() {
                                //End the game.
                                gameManager.getStateManager().changeState(new ShutdownState(gameManager));
                            }
                        }));
            }
        });
    }

    public void start() {
        //TODO Crystals die logic
        this.runTaskTimerAsynchronously(PortalRush.getInstance(), 20, 20L * seconds);
    }
}
