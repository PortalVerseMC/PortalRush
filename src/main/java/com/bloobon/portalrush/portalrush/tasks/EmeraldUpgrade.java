package com.bloobon.portalrush.portalrush.tasks;

import com.bloobon.portalrush.portalrush.PortalRush;
import com.bloobon.portalrush.portalrush.gamestates.CrystalDieState;
import com.bloobon.portalrush.portalrush.gamestates.EmeraldUpgradeState;
import com.bloobon.portalrush.portalrush.managers.game.GameManager;
import com.bloobon.portalrush.portalrush.managers.players.PlayerManager;
import lombok.Getter;
import org.bukkit.scheduler.BukkitRunnable;

public class EmeraldUpgrade extends Countdown {
    @Getter
    private final int level;
    @Getter
    private final int limit;

    public EmeraldUpgrade(int level, int limit, int seconds, GameManager gameManager) {
        super(seconds, gameManager, new BukkitRunnable() {
            @Override
            public void run() {
                if (level <= limit) {
                    gameManager.getStateManager().changeState(
                            new EmeraldUpgradeState(gameManager, PlayerManager.SECOND_EMERALD_UPGRADE));
                }
                else {
                    gameManager.getStateManager().changeState(
                            new CrystalDieState(gameManager, PlayerManager.CRYSTALS_DIE));
                }

            }
        });
        this.level = level;
        this.limit = limit;
    }

    public void start(){
        //TODO Upgrade logic of emerald upgrade
        //The level variable represents the emerald upgrade level
        this.runTaskTimerAsynchronously(PortalRush.getInstance(), 20, 20L * seconds);
    }
}
