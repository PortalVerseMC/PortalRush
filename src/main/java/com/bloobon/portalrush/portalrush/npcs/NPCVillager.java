package com.bloobon.portalrush.portalrush.npcs;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerDestroyEntities;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityMetadata;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnEntity;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import io.github.retrooper.packetevents.util.SpigotReflectionUtil;
import lombok.Getter;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.UUID;

@Getter
public abstract class NPCVillager implements NPC {
    private final Location location;

    private WrapperEntity entity;

    private Component name;
    private int entityId;
    private UUID uuid;

    public NPCVillager(Location location, Component name) {
        this.entityId = SpigotReflectionUtil.generateEntityId();
        this.uuid = UUID.randomUUID();
        this.location = location;
        this.name = name;
        this.entity = EntityLib.getApi().createEntity(uuid, entityId, EntityTypes.VILLAGER);
    }

    public void addViewer(Player player) {
        WrapperPlayServerSpawnEntity spawnPacket = new WrapperPlayServerSpawnEntity(getEntityId(), getUuid(),
                EntityTypes.VILLAGER, SpigotConversionUtil.fromBukkitLocation(getLocation()),
                this.getLocation().getYaw(), 0, null);
        PacketEvents.getAPI().getPlayerManager().writePacket(player, spawnPacket);

        //Add custom name
        EntityMeta meta = entity.getEntityMeta();
        meta.setCustomNameVisible(true);
        meta.setCustomName(name);

        WrapperPlayServerEntityMetadata metadata = new WrapperPlayServerEntityMetadata(entityId, meta);
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, metadata);
    }

    public void removeViewer(Player player) {
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
