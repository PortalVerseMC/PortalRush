package com.bloobon.portalrush.portalrush.type;

import org.bukkit.Material;

public enum GeneratorType implements Type<Material> {

    IRON(Material.IRON_INGOT),
    GOLD(Material.GOLD_INGOT),
    DIAMOND(Material.DIAMOND),
    EMERALD(Material.EMERALD);

    private final Material material;

    GeneratorType(Material material){
        this.material = material;
    }

    @Override
    public Material getType() {
        return material;
    }
}
