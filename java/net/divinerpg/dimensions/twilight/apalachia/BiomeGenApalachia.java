package net.divinerpg.dimensions.twilight.apalachia;

import java.awt.Color;

import net.divinerpg.utils.blocks.TwilightBlocks;
import net.minecraft.world.biome.BiomeGenBase;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeGenApalachia extends BiomeGenBase {

	public BiomeGenApalachia(int par1) {
		super(par1);
		this.setBiomeName("Apalachia");
		this.topBlock = TwilightBlocks.apalachiaGrass;
		this.fillerBlock = TwilightBlocks.apalachiaDirt;
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.waterColorMultiplier = 2368548;
        this.theBiomeDecorator.treesPerChunk = 6;
	}
}