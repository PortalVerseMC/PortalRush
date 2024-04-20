package com.bloobon.portalrush.portalrush.tasks;

import com.bloobon.portalrush.portalrush.PortalRush;
import com.bloobon.portalrush.portalrush.gamestates.DiamondUpgradeState;
import com.bloobon.portalrush.portalrush.gamestates.EmeraldUpgradeState;
import com.bloobon.portalrush.portalrush.managers.game.GameManager;
import com.bloobon.portalrush.portalrush.managers.players.PlayerManager;
import lombok.Getter;
import org.bukkit.scheduler.BukkitRunnable;

public class DiamondUpgrade extends Countdown {
    @Getter
    private final int level;
    @Getter
    private final int limit;

    public DiamondUpgrade(int level, int limit, int seconds, GameManager gameManager) {
        super(seconds, gameManager, new BukkitRunnable() {
            @Override
            public void run() {
                if (level <= limit) {
                    gameManager.getStateManager().changeState(
                            new DiamondUpgradeState(gameManager, PlayerManager.SECOND_DIAMOND_UPGRADE));
                }
                else {
                    gameManager.getStateManager().changeState(
                            new EmeraldUpgradeState(gameManager, PlayerManager.FIRST_EMERALD_UPGRADE));
                }

            }
        });
        this.level = level;
        this.limit = limit;
    }

    public void start(){
        //TODO Upgrade logic of diamond upgrade
        //The level variable represents the diamond upgrade level
        this.runTaskTimerAsynchronously(PortalRush.getInstance(), 20, 20L * seconds);
    }
}
