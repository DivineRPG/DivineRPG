package net.divinerpg.dimensions.arcana;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenArcana extends BiomeGenBase {
	
    public BiomeGenArcana(int id) {
        super(id);
        this.setBiomeName("Arcana");
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.topBlock = (Block)null;
        this.fillerBlock = (Block)null;
        this.waterColorMultiplier = 2368548;
    }
}