package com.bloobon.portalrush.portalrush;

import com.bloobon.portalrush.portalrush.commands.PortalRushCommand;
import com.bloobon.portalrush.portalrush.listeners.ConnectionListener;
import com.bloobon.portalrush.portalrush.listeners.IslandGeneratorListener;
import com.bloobon.portalrush.portalrush.listeners.PacketEventsListener;
import com.bloobon.portalrush.portalrush.managers.game.GameManager;
import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.event.PacketListenerPriority;
import io.github.retrooper.packetevents.factory.spigot.SpigotPacketEventsBuilder;
import lombok.Getter;
import me.tofaa.entitylib.APIConfig;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.spigot.SpigotEntityLibPlatform;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class PortalRush extends JavaPlugin {

    @Getter
    private static PortalRush instance;
    @Getter
    private GameManager gameManager;

    @Override
    public void onLoad() {
        PacketEvents.setAPI(SpigotPacketEventsBuilder.build(this));
        PacketEvents.getAPI().load();
        SpigotEntityLibPlatform entityLibPlatform = new SpigotEntityLibPlatform(this);
        APIConfig entityLibConfig = new APIConfig(PacketEvents.getAPI());
        EntityLib.init(entityLibPlatform, entityLibConfig);
    }

    @Override
    public void onEnable() {
        instance = this;

        PacketEvents.getAPI().getEventManager().registerListener(new PacketEventsListener(), PacketListenerPriority.NORMAL);
        PacketEvents.getAPI().init();
        // Plugin startup logic
        gameManager = new GameManager();

        Bukkit.getPluginManager().registerEvents(new ConnectionListener(this), this);
        Bukkit.getPluginManager().registerEvents(new IslandGeneratorListener(), this);
        new PortalRushCommand(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        PacketEvents.getAPI().terminate();
    }
}
