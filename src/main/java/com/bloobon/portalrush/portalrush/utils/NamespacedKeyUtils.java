package com.bloobon.portalrush.portalrush.utils;

import com.bloobon.portalrush.portalrush.PortalRush;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public final class NamespacedKeyUtils {

    private NamespacedKeyUtils(){}

    public static ItemStack addNamespacedKey(ItemStack itemStack, String key){
        ItemMeta meta = itemStack.getItemMeta();
        if(meta.getPersistentDataContainer().has(new NamespacedKey(PortalRush.getInstance(), key))) return itemStack;
        meta.getPersistentDataContainer().set(new NamespacedKey(PortalRush.getInstance(), key), PersistentDataType.BYTE, (byte) 0b1);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public static boolean hasNamespacedKey(ItemStack itemStack, String key){
        ItemMeta meta = itemStack.getItemMeta();
        return (meta.getPersistentDataContainer().has(new NamespacedKey(PortalRush.getInstance(), key)));
    }
}
