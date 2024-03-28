package com.bloobon.portalrush.portalrush.utils;

import com.bloobon.portalrush.portalrush.npcs.NPC;
import com.bloobon.portalrush.portalrush.npcs.NPCVillager;

import java.util.HashMap;
import java.util.Map;

public class NPCUtil {
    private static final Map<Integer, NPCVillager> NPC_MAP = new HashMap<>();

    public static void registerNPC(int entityId, NPCVillager npc) {
        NPC_MAP.put(entityId, npc);
    }

    public static NPCVillager getNPCById(int entityId) {
        return NPC_MAP.get(entityId);
    }

    public static void unregisterNPC(int entityId) {
        NPC_MAP.remove(entityId);
    }
}
