package naturix.divinerpg.dimensions.mortum;

import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.ChunkGeneratorHell;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.MapGenBase;
import scala.actors.remote.SendTo;

import javax.annotation.Nullable;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;

public class MortumChunkGenerator extends ChunkGeneratorHell {

    public static IBlockState GRASS = ModBlocks.mortumGrass.getDefaultState();
    public static IBlockState DIRT = ModBlocks.mortumDirt.getDefaultState();
    public static IBlockState STONE = ModBlocks.twilightStone.getDefaultState();

    private final Random rand;
    private final MapGenBase genNetherCaves;


    private World world;

    public MortumChunkGenerator(World worldIn, long seed) {
        super(worldIn, false, seed);
        world = worldIn;

        // getting private fields
        rand = this.getSuperFieldValue("rand");
        genNetherCaves = this.getSuperFieldValue("genNetherCaves");
    }

    @Override
    public Chunk generateChunk(int x, int z) {
        this.rand.setSeed((long)x * 341873128712L + (long)z * 132897987541L);
        ChunkPrimer chunkprimer = new ChunkPrimer();
        this.prepareHeights(x, z, chunkprimer);
        this.buildSurfaces(x, z, chunkprimer);
        this.genNetherCaves.generate(this.world, x, z, chunkprimer);

        replaceBlocks(chunkprimer);

        Chunk chunk = new Chunk(this.world, chunkprimer, x, z);
        Biome[] abiome = this.world.getBiomeProvider().getBiomes(null, x * 16, z * 16, 16, 16);
        byte[] abyte = chunk.getBiomeArray();

        for (int i = 0; i < abyte.length; ++i)
        {
            abyte[i] = (byte)Biome.getIdForBiome(abiome[i]);
        }

        chunk.resetRelightChecks();
        return chunk;
    }

    @Override
    public void populate(int x, int z) {
        int i = x * 16;
        int j = z * 16;
        BlockPos blockpos = new BlockPos(i, 0, j);
        Biome biome = this.world.getBiome(blockpos.add(16, 0, 16));

        biome.decorate(this.world, rand, new BlockPos(i, 0, j));
    }

    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
        Biome biome = this.world.getBiome(pos);
        return biome.getSpawnableList(creatureType);
    }

    @Override
    public void recreateStructures(Chunk chunkIn, int x, int z) {
        // empty
    }

    private <T> T getSuperFieldValue(String name){
        try {
            Field field = ChunkGeneratorHell.class.getDeclaredField(name);
            field.setAccessible(true);

            return (T) field.get(this);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void replaceBlocks(ChunkPrimer primer){
        for (int x = 0; x < 16; x++){
            // going from top to bottom
            for (int y = 127; y >= 0; y--){
                for (int z = 0; z < 16; z++){
                    IBlockState state = primer.getBlockState(x, y, z);

                    // trying to set surface block
                    if (state == ChunkGeneratorHell.AIR && y > 1){
                        IBlockState below = primer.getBlockState(x, y - 1, z);

                        // trying to check below block
                        if (below == ChunkGeneratorHell.NETHERRACK
                        || below == ChunkGeneratorHell.SOUL_SAND
                        || below == ChunkGeneratorHell.GRAVEL){
                            primer.setBlockState(x, y-1, z, GRASS);
                        } else if (below == LAVA){
                            primer.setBlockState(x, y-1, z, STONE);
                        }
                    } else if (state == ChunkGeneratorHell.NETHERRACK
                            || state == ChunkGeneratorHell.SOUL_SAND
                            || state == ChunkGeneratorHell.GRAVEL){
                        primer.setBlockState(x,y,z, DIRT);
                    } else if (state == ChunkGeneratorHell.LAVA){
                        primer.setBlockState(x,y,z, STONE);
                    }
                }
            }
        }
    }
}
