package divinerpg.dimensions.apalachia;

import java.awt.Color;
import java.util.Random;

import divinerpg.registry.ModBlocks;
import divinerpg.world.features.WorldGenTwilightDoublePlants;
import divinerpg.world.features.WorldGenTwilightSinglePlants;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeApalachia extends Biome {

    private static BiomeProperties properties = new BiomeProperties("Apalachia");
    private World world;
    private Random rand;
    private BlockPos pos;

    public BiomeApalachia() {
        super(properties);
        this.topBlock = ModBlocks.apalachiaGrass.getDefaultState();
        this.fillerBlock = ModBlocks.apalachiaDirt.getDefaultState();
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
        ApalachiaTree genTree = new ApalachiaTree(false, 5);
        ApalachiaTreeLarge genLargeTree = new ApalachiaTreeLarge(true, 5);
        WorldGenLakes genLakes = new WorldGenLakes(Blocks.WATER);
        WorldGenTwilightDoublePlants genDuskFlower = new WorldGenTwilightDoublePlants(ModBlocks.duskFlower,
                ModBlocks.apalachiaGrass);
        WorldGenTwilightSinglePlants genTallGrass = new WorldGenTwilightSinglePlants(ModBlocks.apalachiaTallgrass,
                ModBlocks.apalachiaGrass);
        WorldGenTwilightSinglePlants genDuskBloom = new WorldGenTwilightSinglePlants(ModBlocks.duskBloom,
                ModBlocks.apalachiaGrass);

        BlockPos.MutableBlockPos mutPos = new BlockPos.MutableBlockPos(0, 0, 0);
        for (int i = 0; i < 40; i++) {
            int rx = pos.getX() + rand.nextInt(16) + 8;
            int ry = 13 + rand.nextInt(80);
            int rz = pos.getZ() + rand.nextInt(16) + 8;
            mutPos.setPos(rx, ry, rz);
            genLargeTree.generate(worldIn, rand, mutPos);
        }
        for (int i = 0; i < 30; i++) {
            int rx = pos.getX() + rand.nextInt(16) + 8;
            int ry = 13 + rand.nextInt(80);
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
        for (int i = 0; i < 12; i++) {
            int rx = pos.getX() + rand.nextInt(16) + 8;
            int ry = 13 + rand.nextInt(80);
            int rz = pos.getZ() + rand.nextInt(16) + 8;
            mutPos.setPos(rx, ry, rz);
            genDuskFlower.generate(worldIn, rand, mutPos);
        }
        for (int i = 0; i < 20; i++) {
            int rx = pos.getX() + rand.nextInt(16) + 8;
            int ry = 13 + rand.nextInt(80);
            int rz = pos.getZ() + rand.nextInt(16) + 8;
            mutPos.setPos(rx, ry, rz);
            genTallGrass.generate(worldIn, rand, mutPos);
        }
        for (int i = 0; i < 12; i++) {
            int rx = pos.getX() + rand.nextInt(16) + 8;
            int ry = 13 + rand.nextInt(80);
            int rz = pos.getZ() + rand.nextInt(16) + 8;
            mutPos.setPos(rx, ry, rz);
            genDuskBloom.generate(worldIn, rand, mutPos);
        }
    }
}