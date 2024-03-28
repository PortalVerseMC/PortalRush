package com.bloobon.portalrush.portalrush.npcs;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerDestroyEntities;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnEntity;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnLivingEntity;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnPlayer;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import io.github.retrooper.packetevents.util.SpigotReflectionUtil;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
@Getter
public abstract class NPCVillager implements NPC {
    private final Player entity;
    private final Location location;

    private Component name;
    private int entityId;
    private UUID uuid;

    public NPCVillager(Player entity, Location location, Component name) {
        this.entityId = SpigotReflectionUtil.generateEntityId();
        this.entity = entity;
        this.uuid = UUID.randomUUID();
        this.location = location;
        this.name = name;
    }

    public void spawnFor(Player player) {
        PacketWrapper<?> spawnPacket;
        if (PacketEvents.getAPI().getServerManager().getVersion().isNewerThanOrEquals(ServerVersion.V_1_20_2)) {
            spawnPacket = new WrapperPlayServerSpawnEntity(getEntityId(), getUuid(),
                    EntityTypes.VILLAGER, SpigotConversionUtil.fromBukkitLocation(getLocation()),
                    this.getLocation().getYaw(), 0, null);
        } else {
            spawnPacket = new WrapperPlayServerSpawnLivingEntity(getEntityId(), getUuid(),
                    EntityTypes.VILLAGER, SpigotConversionUtil.fromBukkitLocation(getLocation()),
                    0, new Vector3d(), new ArrayList<>());
        }
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, spawnPacket);
    }

    public void despawnFor(Player player) {
        WrapperPlayServerDestroyEntities destroyEntities = new WrapperPlayServerDestroyEntities(entityId);
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, destroyEntities);
    }

    public Location getEyeLocation() {
        Location loc = getLocation().clone();
        loc.setY(loc.getY() + 1.62F);
        return loc;
    }

    public abstract void handleLeftClick(Player player);
    public abstract void handleRightClick(Player player);
}
