package net.divinerpg.dimensions.iceika;

import java.awt.Color;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.divinerpg.utils.blocks.IceikaBlocks;
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
        this.setEnableSnow();
        this.setTemperatureRainfall(0.0f, 0.5f);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float par1) {
        return 0x00196F;
    }
}