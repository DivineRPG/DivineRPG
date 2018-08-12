package naturix.divinerpg.world.biomes;

import java.util.Random;

import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.world.TreeGen;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeEden extends Biome 
{
	protected static final TreeGen TREE = new TreeGen(true, ModBlocks.divineLog.getDefaultState(), ModBlocks.divineLeaves.getDefaultState());
	
	public BiomeEden() 
	{
		super(new BiomeProperties("Eden").setBaseHeight(1.5F).setHeightVariation(1.2F).setTemperature(0.6F).setRainDisabled().setWaterColor(16711680));
		
		topBlock = Blocks.DIRT.getDefaultState();
		fillerBlock = ModBlocks.oreEden.getDefaultState();
		
		this.decorator.treesPerChunk = 2;
		
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		
		this.spawnableCreatureList.add(new SpawnListEntry(EntityWither.class, 10, 1, 5));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityDragon.class, 5, 1, 2));
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) 
	{
		return TREE;
	}
}