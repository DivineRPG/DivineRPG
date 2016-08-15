package net.divinerpg.dimensions.vethea;

import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenVethea extends BiomeGenBase {
	
    public BiomeGenVethea(int var1) {
        super(var1);
        this.setBiomeName("Arksiane");
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.topBlock = VetheaBlocks.dreamGrass;
        this.fillerBlock = VetheaBlocks.dreamDirt;
        setDisableRain();
    }
}