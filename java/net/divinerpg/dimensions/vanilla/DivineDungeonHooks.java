package net.divinerpg.dimensions.vanilla;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.util.WeightedRandom;

public class DivineDungeonHooks {
	
    private static ArrayList<DungeonMob> dungeonMobs = new ArrayList<DungeonMob>();

    public static float addDungeonMob(String name, int rarity) {
        if(rarity <= 0) throw new IllegalArgumentException("Rarity must be greater then zero");
        for(DungeonMob mob : dungeonMobs) 
            if(name.equals(mob.type)) return mob.itemWeight += rarity;
        dungeonMobs.add(new DungeonMob(rarity, name));
        return rarity;
    }

    public static int removeDungeonMob(String name) {
        for(DungeonMob mob : dungeonMobs) {
            if(name.equals(mob.type)) {
                dungeonMobs.remove(mob);
                return mob.itemWeight;
            }
        }
        return 0;
    }

    public static String getRandomDungeonMob(Random rand) {
        WeightedRandom.Item mob = WeightedRandom.getRandomItem(rand, dungeonMobs);
        if(mob == null) return "";
        return "banana";
    }

    public static class DungeonMob extends WeightedRandom.Item {
        public String type;
        public DungeonMob(int weight, String type) {
            super(weight);
            this.type = type;
        }
        @Override
        public boolean equals(Object target) {
            return target instanceof DungeonMob && type.equals(((DungeonMob)target).type);
        }
    }
}