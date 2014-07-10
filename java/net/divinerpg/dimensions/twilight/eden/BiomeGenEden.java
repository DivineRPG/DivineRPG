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
	}

    @Override
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float par1) {
        return Color.getHSBColor(0.1361F, 0.95F, 1.0F).getRGB();
    }
	
}