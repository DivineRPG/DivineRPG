package net.divinerpg.dimensions.vanilla;

import java.util.Random;

import net.divinerpg.utils.blocks.VanillaBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenForest;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.BiomeDictionary;
import cpw.mods.fml.common.IWorldGenerator;

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

	private void generateOverworld(World world, Random random, int x, int z) {
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(x, z);
		
		addOreSpawn(VanillaBlocks.realmiteOre, world, random, x, z, 16, 16, 5, 4, 1, 25);
		addOreSpawn(VanillaBlocks.arlemiteOre, world, random, x, z, 16, 16, 2, 3, 1, 15);
		addOreSpawn(VanillaBlocks.rupeeOre,    world, random, x, z, 16, 16, 2, 3, 1, 15);

		if(random.nextInt(8) == 0) {
			int posX = x + random.nextInt(16) + 8;
			int posY = random.nextInt(150);
			int posZ = z + random.nextInt(16) + 8;
			if(random.nextInt(10) == 0 || posY < 60) (new WorldGenLakes(VanillaBlocks.tar)).generate(world, random, posX, posY, posZ);
		}

		for(int i = 0; i < 3; i++) {
			int posX = x + random.nextInt(16) + 8;
			int posY = random.nextInt(60);
			int posZ = z + random.nextInt(16) + 8;
			(new WorldGenDivineDungeon()).generate(world, random, posX, posY, posZ);
		}
		
		if(BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.FOREST) && !BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.CONIFEROUS) && !BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.JUNGLE) && !BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.DENSE) && biome != BiomeGenBase.birchForest && biome != BiomeGenBase.birchForestHills && random.nextInt(2) == 0) {
			int posX = x + random.nextInt(16);
			int posZ = z + random.nextInt(16);
			int posY = world.getHeightValue(posX, posZ);
			(new WorldGenDivineTree(true)).generate(world, random, posX, posY, posZ);
		}
	}

	private void generateNether(World world, Random random, int x, int z) {
		addNetherOreSpawn(VanillaBlocks.netheriteOre, world, random, x, z, 16, 16, 10, 4, 1, 128);
		addNetherOreSpawn(VanillaBlocks.bloodgemOre,  world, random, x, z, 16, 16, 11, 5, 1, 128);
	}

	private void generateEnd(World world, Random random, int x, int z) { }

	public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int chancesToSpawn, int maxVeinSize, int minY, int maxY) {
		int diffBtwnMinMaxY = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
		}
	}

	public void addNetherOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int chancesToSpawn, int maxVeinSize, int minY, int maxY) {
		int diffBtwnMinMaxY = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenMinable(block, maxVeinSize, Blocks.netherrack)).generate(world, random, posX, posY, posZ);
		}
	}

	public void addEndOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int chancesToSpawn, int maxVeinSize, int minY, int maxY) {
		int diffBtwnMinMaxY = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenMinable(block, maxVeinSize, Blocks.end_stone)).generate(world, random, posX, posY, posZ);
		}
	}
}
