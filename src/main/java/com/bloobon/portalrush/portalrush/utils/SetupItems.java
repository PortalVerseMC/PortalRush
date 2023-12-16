package com.bloobon.portalrush.portalrush.utils;

import org.bukkit.inventory.ItemStack;

public final class SetupItems {

    public static final ItemStack SETUP_ENGINEER;
    public static final ItemStack SETUP_SHOPKEEPER;
    public static final ItemStack SETUP_UPGRADEKEEPER;
    public static final ItemStack SETUP_ISLAND_GENERATOR;
    public static final ItemStack SETUP_GENERATOR;
    public static final ItemStack SETUP_PORTAL;
    public static final ItemStack SETUP_SPAWN_LOCATIONS;
    public static final ItemStack SETUP_CRYSTAL;

    static {
        SETUP_ENGINEER = getSetupEngineer();
        SETUP_SHOPKEEPER = getSetupShopkeeper();
        SETUP_UPGRADEKEEPER = getSetupUpgradekeeper();
        SETUP_GENERATOR = getSetupGenerator();
        SETUP_ISLAND_GENERATOR = getSetupIslandGenerator();
        SETUP_PORTAL = getSetupPortal();
        SETUP_SPAWN_LOCATIONS = getSetupSpawnLocations();
        SETUP_CRYSTAL = getSetupCrystal();
    }

    private SetupItems(){}

    private static ItemStack getSetupEngineer(){
       return null;
    }

    private static ItemStack getSetupShopkeeper(){
        return null;
    }
    private static ItemStack getSetupCrystal(){
        return null;
    }

    private static ItemStack getSetupUpgradekeeper(){
        return null;
    }

    private static ItemStack getSetupGenerator(){
        return null;
    }
    private static ItemStack getSetupIslandGenerator() {
    return null;
    }

    private static ItemStack getSetupPortal(){
        return null;
    }

    private static ItemStack getSetupSpawnLocations(){
        return null;
    }
}
