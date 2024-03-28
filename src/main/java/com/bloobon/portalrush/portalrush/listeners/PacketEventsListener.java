package com.bloobon.portalrush.portalrush.listeners;

import com.bloobon.portalrush.portalrush.npcs.NPC;
import com.bloobon.portalrush.portalrush.npcs.NPCVillager;
import com.bloobon.portalrush.portalrush.utils.NPCUtil;
import com.github.retrooper.packetevents.event.PacketListener;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientInteractEntity;
import org.bukkit.entity.Player;

public class PacketEventsListener implements PacketListener {
    @Override
    public void onPacketReceive(PacketReceiveEvent event) {
        if (event.getPacketType() == PacketType.Play.Client.INTERACT_ENTITY) {
            WrapperPlayClientInteractEntity interactEntity = new WrapperPlayClientInteractEntity(event);
            int entityID = interactEntity.getEntityId();
            //In order for us to access this NPC, we need to have registered it first.
            //NPCUtil.registerNPC(entityID, NPC instance);

            NPCVillager npc = NPCUtil.getNPCById(entityID);
            //If we are not dealing with an NPC, ignore this packet
            if (npc == null) return;
            Player player = (Player) event.getPlayer();

            if (npc.getLocation().distance(player.getLocation()) > 4) {
                //NPC is too far away. Cancel this interaction.
                event.setCancelled(true);
                return;
            }
            //Left click
            if (interactEntity.getAction() == WrapperPlayClientInteractEntity.InteractAction.ATTACK) {
                npc.handleLeftClick(player);
            } //Right click
            else {
                npc.handleRightClick(player);
            }
        }
    }

    @Override
    public void onPacketSend(PacketSendEvent event) {

    }
}
