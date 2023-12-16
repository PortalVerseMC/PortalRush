    package com.bloobon.portalrush.portalrush.upgrades.generators;

    import com.bloobon.portalrush.portalrush.type.GeneratorType;
    import com.bloobon.portalrush.portalrush.managers.upgrades.GeneratorUpgradeCache;
    import lombok.Getter;
    import lombok.NonNull;
    import lombok.RequiredArgsConstructor;

    @RequiredArgsConstructor
    public class GeneratorUpgradeImpl implements GeneratorUpgrade {


        @Getter
        private final GeneratorType generatorType;
        @Getter
        private int level = 1;

        private final GeneratorUpgradeCache upgradeCache;
        @Getter
        private final int maxLevel;

        public GeneratorUpgradeImpl(@NonNull GeneratorType generatorType, @NonNull GeneratorUpgradeCache upgradeCache){
            this.generatorType = generatorType;
            this.upgradeCache = upgradeCache;
            this.maxLevel = upgradeCache.getMaxLevel();
        }

        @Override
        public void addLevel() {
            if(level == maxLevel) return;
            level++;
        }

        @Override
        public int getCurrentInterval() {
            return upgradeCache.getValueOfLevel(generatorType, level);
        }

        @Override
        public int getInterval(int level) {
            return upgradeCache.getValueOfLevel(generatorType, level);
        }
    }
