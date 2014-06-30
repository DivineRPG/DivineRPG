package net.divinerpg.dimension.gen.iceika;

import net.divinerpg.helper.blocks.IceikaBlocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenIceika extends BiomeGenBase{

	public BiomeGenIceika(int par1) {
		super(par1);
		this.setBiomeName("Iceika");
		this.topBlock = IceikaBlocks.frozenGrass;
		this.fillerBlock = IceikaBlocks.frozenDirt;
		this.rainfall = 999;
		this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.enableSnow = true;
	}
}