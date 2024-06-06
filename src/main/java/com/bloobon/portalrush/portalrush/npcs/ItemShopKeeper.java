package com.bloobon.portalrush.portalrush.npcs;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityHeadLook;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityRotation;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

@Getter
public class ItemShopKeeper extends NPCVillager {
    public ItemShopKeeper(Location location) {
        super(location, Component.text("Shop").color(NamedTextColor.GREEN));
    }

    @Override
    public void handleLeftClick(Player player) {
        //TODO Test code
        player.sendMessage("You clicked on an item shop keeper!");
    }

    @Override
    public void handleRightClick(Player player) {
        //TODO Test code
        //Rotate the NPC in the player's direction.
        Vector direction = player.getEyeLocation().clone().subtract(getEyeLocation()).toVector();

        getLocation().setDirection(direction);

        WrapperPlayServerEntityRotation rot = new WrapperPlayServerEntityRotation(getEntityId(),
                getLocation().getYaw(), getLocation().getPitch(), true);

        WrapperPlayServerEntityHeadLook head = new WrapperPlayServerEntityHeadLook(getEntityId(), getLocation().getYaw());
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, head);
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, rot);

        //TODO Debug
        player.sendMessage("Rotated the villager towards you...");

    }
}
