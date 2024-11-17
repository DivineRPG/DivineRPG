package net.divinerpg.dimensions.vanilla;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraftforge.common.BiomeDictionary;

public class DivineWorldgen implements IWorldGenerator{

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
		case -1:
			generateNether(world, rand, chunkX * 16, chunkZ * 16);break;
		case 0:
			generateOverworld(world, rand, chunkX * 16, chunkZ * 16);break;
		case 1:
			generateEnd(world, rand, chunkX * 16, chunkZ * 16);break;
		}
	}
	private static WorldGenDivineTree tree = new WorldGenDivineTree(true);
	private static WorldGenHut hut = new WorldGenHut();
	private void generateOverworld(World world, Random random, int i, int k) {
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(i, k);
		
		for (int c = 0; c < 3; c++) {
		    int x = i + random.nextInt(16);
		    int y = random.nextInt(20);
		    int z = k + random.nextInt(16);
		    new WorldGenOres().generate(VanillaBlocks.realmiteOre, world, random, Blocks.stone, x, y, z, 5);
		}
		
		for (int c = 0; c < 2; c++) {
		    int x = i + random.nextInt(16);
		    int y = random.nextInt(16);
		    int z = k + random.nextInt(16);
		    new WorldGenOres().generate(VanillaBlocks.arlemiteOre, world, random, Blocks.stone, x, y, z, 2);
		}
		
		for (int c = 0; c < 2; c++) {
		    int x = i + random.nextInt(16);
		    int y = random.nextInt(16);
		    int z = k + random.nextInt(16);
		    new WorldGenOres().generate(VanillaBlocks.rupeeOre, world, random, Blocks.stone, x, y, z, 2);
		}

		if(random.nextInt(8) == 0) {
			int posX = i + random.nextInt(16) + 8;
			int posY = random.nextInt(150);
			int posZ = k + random.nextInt(16) + 8;
			if(ConfigurationHelper.generateTar && (random.nextInt(10) == 0 || posY < 60)) (new WorldGenLakes(VanillaBlocks.tar)).generate(world, random, posX, posY, posZ);
		}

		for(int c = 0; c < 3; c++) {
			int posX = i + random.nextInt(16) + 8;
			int posY = random.nextInt(60);
			int posZ = k + random.nextInt(16) + 8;
		}
		
		if(BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.FOREST) && !BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.CONIFEROUS) && !BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.JUNGLE) && !BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.DENSE) && biome != BiomeGenBase.birchForest && biome != BiomeGenBase.birchForestHills && random.nextInt(2) == 0) {
			int posX = i + random.nextInt(16);
			int posZ = k + random.nextInt(16);
			int posY = world.getHeightValue(posX, posZ);
			if(ConfigurationHelper.generateTrees)tree.generate(world, random, posX, posY, posZ);
		}
				
		if(world.provider.terrainType != WorldType.FLAT && (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.PLAINS) || BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.SAVANNA))) {
			if(random.nextInt(36)==0 && ConfigurationHelper.generateHuts)hut.generate(world, random, i+8, world.getHeightValue(i+8, k+8)-1, k+8);
		}
	}

	private void generateNether(World world, Random random, int i, int k) {
	    for (int c = 0; c < 5; c++) {
	        int x = i + random.nextInt(16);
	        int y = random.nextInt(128);
	        int z = k + random.nextInt(16);
	        new WorldGenOres().generate(VanillaBlocks.netheriteOre, world, random, Blocks.netherrack, x, y, z, 4);
	    }
	    
	    for (int c = 0; c < 5; c++) {
	        int x = i + random.nextInt(16);
	        int y = random.nextInt(128);
	        int z = k + random.nextInt(16);
	        new WorldGenOres().generate(VanillaBlocks.bloodgemOre, world, random, Blocks.netherrack, x, y, z, 4);
	    }
	}

	private void generateEnd(World world, Random random, int x, int z) { }
}
