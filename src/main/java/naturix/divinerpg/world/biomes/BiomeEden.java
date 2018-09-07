package naturix.divinerpg.world.biomes;

import java.awt.Color;
import java.util.Random;

import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.world.TreeGen;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeEden extends Biome {
	protected static final TreeGen TREE_FEATURE = new TreeGen(false, ModBlocks.divineLog.getDefaultState(), ModBlocks.divineLeaves.getDefaultState());
    
    private static BiomeProperties properties = new BiomeProperties("eden");
	public BiomeEden(String name) {
	super(properties);
	this.topBlock = ModBlocks.grassEden.getDefaultState();
	this.fillerBlock = ModBlocks.dirtEden.getDefaultState();
    this.spawnableCreatureList.clear();
    this.spawnableMonsterList.clear();
    this.spawnableCaveCreatureList.clear();
    this.spawnableWaterCreatureList.clear();
    this.setRegistryName(name);
    this.addDefaultFlowers();
    TREE_FEATURE.setDecorationDefaults();
    this.decorator.treesPerChunk = 6;
    //this.waterColorMultiplier = 2368548;
}

	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float par1) {
    return Color.getHSBColor(0.1361F, 0.95F, 1.0F).getRGB();
}
	@Override
    public WorldGenAbstractTree getRandomTreeFeature(Random random) {
            return new TreeGen(false, ModBlocks.divineLog.getDefaultState(), ModBlocks.divineLeaves.getDefaultState());
    }
	
}