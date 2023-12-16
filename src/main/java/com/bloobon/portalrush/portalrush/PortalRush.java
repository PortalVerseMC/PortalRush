package com.bloobon.portalrush.portalrush;

import com.bloobon.portalrush.portalrush.commands.PortalRushCommand;
import com.bloobon.portalrush.portalrush.listeners.ConnectionListener;
import com.bloobon.portalrush.portalrush.managers.game.GameManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class PortalRush extends JavaPlugin {

    @Getter
    private static PortalRush instance;
    @Getter
    private GameManager gameManager;
    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
        gameManager = new GameManager();

        Bukkit.getPluginManager().registerEvents(new ConnectionListener(this), this);
        new PortalRushCommand(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
