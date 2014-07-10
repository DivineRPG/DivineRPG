package net.divinerpg.dimensions.twilight.wild_woods;

import java.util.Random;

import net.divinerpg.utils.blocks.TwilightBlocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeGenWildWoods extends BiomeGenBase {

	public BiomeGenWildWoods(int par1) {
		super(par1);
		this.setBiomeName("Wild Woods");
		this.topBlock = TwilightBlocks.wildWoodGrass;
		this.fillerBlock = TwilightBlocks.wildWoodDirt;
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.theBiomeDecorator.treesPerChunk = 6;
        this.waterColorMultiplier = 2368548;
	}
	
	@Override
    public WorldGenAbstractTree func_150567_a(Random rand) {
        return this.worldGeneratorSwamp;
    }
}