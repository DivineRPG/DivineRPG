package net.divinerpg.dimensions.twilight.eden;

import java.awt.Color;

import net.divinerpg.utils.blocks.TwilightBlocks;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeGenEden extends BiomeGenBase {

	public BiomeGenEden(int par1) {
		super(par1);
		this.setBiomeName("Eden");
		this.topBlock = TwilightBlocks.edenGrass;
		this.fillerBlock = TwilightBlocks.edenDirt;
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.theBiomeDecorator.treesPerChunk = 6;
        this.waterColorMultiplier = 2368548;
	}
	
}