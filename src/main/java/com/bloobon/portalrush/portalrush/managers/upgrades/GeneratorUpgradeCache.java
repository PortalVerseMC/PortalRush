package com.bloobon.portalrush.portalrush.managers.upgrades;

import com.bloobon.portalrush.portalrush.type.GeneratorType;
import lombok.NonNull;
import java.util.Map;

public final class GeneratorUpgradeCache implements UpgradeCache<GeneratorType, Integer> {


    private Map<@NonNull GeneratorType, Map<@NonNull Integer, @NonNull Integer>> generatorTypeMap;


    private GeneratorUpgradeCache() {}

    public static void init(@NonNull Map<@NonNull GeneratorType, Map<@NonNull Integer, @NonNull Integer>> generatorTypeMap){
        if(InstanceHolder.instance.generatorTypeMap != null) return;
        InstanceHolder.instance.generatorTypeMap = generatorTypeMap;
    }

    @Override
    @NonNull
    public Integer getValueOfLevel(@NonNull GeneratorType type, int level) {
        Map<Integer, Integer> levelMap = generatorTypeMap.get(type);
        return levelMap.get(level);
    }

    public int getMaxLevel(){
        return generatorTypeMap.size();
    }

    private static final class InstanceHolder {
        private static final GeneratorUpgradeCache instance = new GeneratorUpgradeCache();
    }

    public static GeneratorUpgradeCache getInstance(){
        if(InstanceHolder.instance.generatorTypeMap == null) throw new IllegalStateException("GeneratorUpgradeCache not initialized");
        return InstanceHolder.instance;
    }
}
