package divinerpg.dimensions.vethea;

import divinerpg.DivineRPG;
import divinerpg.registry.BlockRegistry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class BiomeVethea extends Biome {
    private static BiomeProperties properties = new BiomeProperties("Vethea").setRainDisabled();
    private World world;
    private Random rand;
    private BlockPos pos;

    public static final int LAYER_1_GROUND_HEIGHT = 17;
    public static final int LAYER_2_GROUND_HEIGHT = 65;
    public static final int LAYER_3_GROUND_HEIGHT = 113;
    public static final int LAYER_4_GROUND_HEIGHT = 161;

    public BiomeVethea() {
        super(properties);
        this.setRegistryName(DivineRPG.MODID, "Vethea");

        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.topBlock = BlockRegistry.dreamGrass.getDefaultState();
        this.fillerBlock = BlockRegistry.dreamDirt.getDefaultState();
        this.flowers.clear();
        this.decorator.flowersPerChunk = 0;
        this.decorator.grassPerChunk = 0;
    }

    @Override
    public void decorate(World worldIn, Random rand, BlockPos pos) {
        WorldGenerator genHyrewoodTree = new WorldGenHyrewoodTree(false);
        WorldGenerator genFirewoodTree = new WorldGenFirewoodTree(false);

        int currentX = pos.getX();
        int currentZ = pos.getZ();

        for(int k = 0; k < rand.nextInt(4); k++) {
            int x = currentX + rand.nextInt(16) + 8;
            int z = currentZ + rand.nextInt(16) + 8;
            BlockPos treePos = new BlockPos(x, LAYER_1_GROUND_HEIGHT, z);
            genHyrewoodTree.generate(worldIn, rand, treePos);
        }

        for(int k = 0; k < rand.nextInt(4); k++) {
            int x = currentX + rand.nextInt(16) + 8;
            int z = currentZ + rand.nextInt(16) + 8;
            BlockPos treePos = new BlockPos(x, LAYER_2_GROUND_HEIGHT, z);
            genFirewoodTree.generate(worldIn, rand, treePos);
        }

        for(int k = 0; k < rand.nextInt(4); k++) {
            int x = currentX + rand.nextInt(16) + 8;
            int z = currentZ + rand.nextInt(16) + 8;
            BlockPos treePos = new BlockPos(x, LAYER_3_GROUND_HEIGHT, z);
            genHyrewoodTree.generate(worldIn, rand, treePos);
        }

        for(int k = 0; k < rand.nextInt(4); k++) {
            int x = currentX + rand.nextInt(16) + 8;
            int z = currentZ + rand.nextInt(16) + 8;
            BlockPos treePos = new BlockPos(x, LAYER_4_GROUND_HEIGHT, z);
            genFirewoodTree.generate(worldIn, rand, treePos);
        }
    }
}