package divinerpg.dimensions.eden;

import java.awt.Color;
import java.util.Random;

import divinerpg.Reference;
import divinerpg.registry.ModBlocks;
import divinerpg.world.features.WorldGenTwilightSinglePlants;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeEden extends Biome {

    private static BiomeProperties properties = new BiomeProperties("eden");
    private World world;
    private Random rand;
    private BlockPos pos;

    public BiomeEden() {
        super(properties);
        this.setRegistryName(Reference.MODID, "eden");

        this.topBlock = ModBlocks.edenGrass.getDefaultState();
        this.fillerBlock = ModBlocks.edenDirt.getDefaultState();
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
        return Color.getHSBColor(0.1361F, 0.95F, 1.0F).getRGB();
    }

    @Override
    public void decorate(World worldIn, Random rand, BlockPos pos) {
        EdenTree genTree = new EdenTree(false, 3);
        LargeEdenTree genLargeTree = new LargeEdenTree(false, 7, ModBlocks.edenLogs.getDefaultState(),
                ModBlocks.edenLeaves.getDefaultState());
        WorldGenConeUp genConeUp = new WorldGenConeUp(ModBlocks.divineMossystone);
        WorldGenLakes genLakes = new WorldGenLakes(Blocks.WATER);
        WorldGenTwilightSinglePlants brush = new WorldGenTwilightSinglePlants(ModBlocks.edenBrush, ModBlocks.edenGrass);
        WorldGenTwilightSinglePlants bloom = new WorldGenTwilightSinglePlants(ModBlocks.sunbloom, ModBlocks.edenGrass);
        WorldGenTwilightSinglePlants blossom = new WorldGenTwilightSinglePlants(ModBlocks.sunBlossom,
                ModBlocks.edenGrass);

        BlockPos.MutableBlockPos mutPos = new BlockPos.MutableBlockPos(0, 0, 0);
        for (int i = 0; i < 4; i++) {
            int rx = pos.getX() + rand.nextInt(16) + 8;
            int ry = 13 + rand.nextInt(80);
            int rz = pos.getZ() + rand.nextInt(16) + 8;
            mutPos.setPos(rx, ry, rz);
            bloom.generate(worldIn, rand, mutPos);
            genLargeTree.generate(worldIn, rand, mutPos);
        }
        for (int i = 0; i < 10; i++) {
            int rx = pos.getX() + rand.nextInt(16) + 8;
            int ry = 13 + rand.nextInt(80);
            int rz = pos.getZ() + rand.nextInt(16) + 8;
            mutPos.setPos(rx, ry, rz);
            brush.generate(worldIn, rand, mutPos);
            blossom.generate(worldIn, rand, mutPos);
        }
        for (int i = 0; i < 100; i++) {
            int rx = pos.getX() + rand.nextInt(16) + 8;
            int ry = 13 + rand.nextInt(80);
            int rz = pos.getZ() + rand.nextInt(16) + 8;
            mutPos.setPos(rx, ry, rz);
            brush.generate(worldIn, rand, mutPos);
        }
        for (int i = 0; i < 10; i++) {
            int rx = pos.getX() + rand.nextInt(16) + 8;
            int ry = 55 + rand.nextInt(20);
            int rz = pos.getZ() + rand.nextInt(16) + 8;
            mutPos.setPos(rx, ry, rz);
            genTree.generate(worldIn, rand, mutPos);
        }
        for (int i = 0; i < 1; i++) {
            int rx = pos.getX() + rand.nextInt(16) + 8;
            int ry = 55 + rand.nextInt(20);
            int rz = pos.getZ() + rand.nextInt(16) + 8;
            mutPos.setPos(rx, ry, rz);
            genLakes.generate(worldIn, rand, mutPos);
        }
        for (int i = 0; i < 1; i++) {
            int rx = pos.getX() + rand.nextInt(16) + 8;
            int ry = 55 + rand.nextInt(20);
            int rz = pos.getZ() + rand.nextInt(16) + 8;
            mutPos.setPos(rx, ry, rz);
            genConeUp.generate(worldIn, rand, mutPos);
        }
    }
}