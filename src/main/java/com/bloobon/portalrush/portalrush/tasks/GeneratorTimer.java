package com.bloobon.portalrush.portalrush.tasks;

import com.bloobon.portalrush.portalrush.PortalRush;
import com.bloobon.portalrush.portalrush.generator.AbstractGenerator;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
@RequiredArgsConstructor
public class GeneratorTimer extends BukkitRunnable {

    private final AbstractGenerator generator;
    private long lastTimeGenerated;

    @Override
    public void run() {

        generator.getLocation().getWorld().dropItem(generator.getLocation(), new ItemStack(generator.getGeneratorType().getType(), generator.getAmount()));

    }

    public void start(){

        int nextDelay = 0;
        if(lastTimeGenerated == 0) nextDelay = generator.getInterval();
        else {
            nextDelay = Math.toIntExact(((System.currentTimeMillis() - lastTimeGenerated) / 1000) * 20);
        }
        lastTimeGenerated = System.currentTimeMillis();
        this.runTaskTimer(PortalRush.getInstance(), nextDelay, generator.getInterval());
    }

    public void cancelTask(){
        if(!this.isCancelled()) this.cancel();
    }
}
