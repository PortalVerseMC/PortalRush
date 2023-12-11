package com.bloobon.portalrush.portalrush.generator;

import org.bukkit.Material;

public enum GeneratorType {

    IRON("IRON_INGOT"),
    GOLD("GOLD_INGOT"),
    DIAMOND("DIAMOND"),
    EMERALD("EMERALD");

    private String material;

    public Material getMaterial(){
        return Material.valueOf(material);
    }

    GeneratorType(String material){
        this.material = material;
    }
}
