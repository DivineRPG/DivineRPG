package divinerpg.dimensions.iceika;

import divinerpg.DivineRPG;
import divinerpg.registry.BlockRegistry;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BiomeIceika extends Biome {

    private static BiomeProperties properties = new BiomeProperties("Iceika").setTemperature(0.0f).setRainfall(0.5f)
            .setSnowEnabled().setHeightVariation(0.5F);

    WorldGenTallGrass tallGrass = new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
    WorldGenerator genIceTree = new IceTreeGen(false, false);


    public BiomeIceika() {
        super(properties);
        this.setRegistryName(DivineRPG.MODID, "iceika");

        this.topBlock = BlockRegistry.frozenGrass.getDefaultState();
        this.fillerBlock = BlockRegistry.frozenDirt.getDefaultState();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.flowers.clear();
        this.decorator.flowersPerChunk = 0;
        this.decorator.grassPerChunk = 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float par1) {
        return 100;
    }

    @Override
    public boolean getEnableSnow() {
        return true;
    }

    @Override
    public int getModdedBiomeFoliageColor(int original) {
        return 3734015;
    }

    @Override
    public int getModdedBiomeGrassColor(int original) {
        return 3734015;
    }

    @Override
    public boolean canRain() {
        return false;
    }

    @Override
    public TempCategory getTempCategory() {
        return TempCategory.COLD;
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        this.generateIceikaTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }

    @Override
    public void decorate(World worldIn, Random rand, BlockPos pos) {

        BlockPos.MutableBlockPos mutPos = new BlockPos.MutableBlockPos(0, 0, 0);

        for (int i = 0; i < 40; i++) {
            int rx = pos.getX() + rand.nextInt(16) + 8;
            int ry = worldIn.getSeaLevel() + rand.nextInt(60);
            int rz = pos.getZ() + rand.nextInt(16) + 8;
            mutPos.setPos(rx, ry, rz);
            genIceTree.generate(worldIn, rand, mutPos);
        }
        for (int i = 0; i < 1; i++) {
            int rx = pos.getX() + rand.nextInt(16) + 8;
            int ry = worldIn.getSeaLevel() + rand.nextInt(60);
            int rz = pos.getZ() + rand.nextInt(16) + 8;
            mutPos.setPos(rx, ry, rz);
            tallGrass.generate(worldIn, rand, mutPos);
        }
    }

    protected void generateIceikaTerrain(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z,
                                         double noiseVal) {
        int seaLevel = worldIn.getSeaLevel();
        IBlockState topBlock = this.topBlock;
        IBlockState fillerBlock = this.fillerBlock;
        int j = -1;
        int k = (int) (noiseVal / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
        int chunkX = x & 15;
        int chunkZ = z & 15;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
        for (int currentY = 255; currentY >= 0; --currentY) {
            if (currentY <= rand.nextInt(5)) {
                chunkPrimerIn.setBlockState(chunkZ, currentY, chunkX, Blocks.BEDROCK.getDefaultState());
            } else {
                IBlockState iblockstate2 = chunkPrimerIn.getBlockState(chunkZ, currentY, chunkX);

                if (iblockstate2.getMaterial() == Material.AIR) {
                    j = -1;
                } else if (iblockstate2.getBlock() == BlockRegistry.frozenStone) {
                    if (j == -1) {
                        if (k <= 0) {
                            topBlock = AIR;
                            fillerBlock = STONE;
                        } else if (currentY >= seaLevel - 4 && currentY <= seaLevel + 1) {
                            topBlock = BlockRegistry.frozenGrass.getDefaultState();
                            fillerBlock = BlockRegistry.frozenDirt.getDefaultState();
                        }

                        if (currentY < seaLevel && (topBlock == null || topBlock.getMaterial() == Material.AIR)) {
                            if (this.getTemperature(blockpos$mutableblockpos.setPos(x, currentY, z)) < 0.15F) {
                                topBlock = ICE;
                            } else {
                                topBlock = WATER;
                            }
                        }

                        j = k;

                        if (currentY >= seaLevel - 1) {
                            chunkPrimerIn.setBlockState(chunkZ, currentY, chunkX, topBlock);
                        } else if (currentY < seaLevel - 7 - k) {
                            topBlock = AIR;
                            fillerBlock = BlockRegistry.frozenStone.getDefaultState();
                        } else {
                            chunkPrimerIn.setBlockState(chunkZ, currentY, chunkX, fillerBlock);
                        }
                    } else if (j > 0) {
                        --j;
                        chunkPrimerIn.setBlockState(chunkZ, currentY, chunkX, fillerBlock);

                        if (j == 0 && fillerBlock.getBlock() == Blocks.SAND && k > 1) {
                            j = rand.nextInt(4) + Math.max(0, currentY - 63);
                            fillerBlock = fillerBlock.getValue(BlockSand.VARIANT) == BlockSand.EnumType.RED_SAND ?
                                    RED_SANDSTONE : SANDSTONE;
                        }
                    }
                }
            }
        }
    }
}