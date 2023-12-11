package com.bloobon.portalrush.region;

import lombok.RequiredArgsConstructor;
import org.bukkit.Location;

@RequiredArgsConstructor
public class CuboidRegion implements Region {

    private final Location cornerFrom;
    private final Location cornerTo;


    public boolean isWithinRegion(Location location){
        int minX = Math.min(cornerFrom.getBlockX(), cornerTo.getBlockX());
        int minY = Math.min(cornerFrom.getBlockY(), cornerTo.getBlockY());
        int minZ = Math.min(cornerFrom.getBlockZ(), cornerTo.getBlockZ());

        int maxX = Math.max(cornerFrom.getBlockX(), cornerTo.getBlockX());
        int maxY = Math.max(cornerFrom.getBlockY(), cornerTo.getBlockY());
        int maxZ = Math.max(cornerFrom.getBlockZ(), cornerTo.getBlockZ());

        int currX = location.getBlockX();
        int currY = location.getBlockY();
        int currZ = location.getBlockZ();

        return currX >= minX && currX <= maxX && currY >= minY && currY <= maxY && currZ >= minZ && currZ <= maxZ;
    }
}
