package naturix.divinerpg.dimensions.mortum;

import java.awt.Color;
import java.util.Random;

import naturix.divinerpg.dimensions.eden.WorldGenConeUp;
import naturix.divinerpg.dimensions.skythern.SkythernTree;
import naturix.divinerpg.dimensions.skythern.SkythernTreeLarge;
import naturix.divinerpg.dimensions.skythern.WorldGenSkythernPlants;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.world.features.WorldGenTwilightDoublePlants;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeMortum extends Biome {

    private static BiomeProperties properties = new BiomeProperties("Mortum");
    private World world;
    private Random rand;
    private BlockPos pos;

    public BiomeMortum() {
        super(properties);
        this.topBlock = ModBlocks.mortumGrass.getDefaultState();
        this.fillerBlock = ModBlocks.mortumDirt.getDefaultState();
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
        MortumTree genTree = new MortumTree(false, 5);
        MortumTreeLarge genLargeTree = new MortumTreeLarge(true, 5);
        WorldGenConeUp genConeUp = new WorldGenConeUp(ModBlocks.divineMossystone);
        WorldGenMortumPlants brush = new WorldGenMortumPlants(ModBlocks.mortumBrush);
        WorldGenMortumPlants bloom = new WorldGenMortumPlants(ModBlocks.eyePlant);
        WorldGenTwilightDoublePlants blossom = new WorldGenTwilightDoublePlants(ModBlocks.demonBrambles, ModBlocks.mortumGrass);

        BlockPos.MutableBlockPos mutPos = new BlockPos.MutableBlockPos(0, 0, 0);
        for (int i = 0; i < 40; i++) {
            int rx = pos.getX() + rand.nextInt(16) + 8;
            int ry = 13 + rand.nextInt(80);
            int rz = pos.getZ() + rand.nextInt(16) + 8;
            mutPos.setPos(rx, ry, rz);
            bloom.generate(worldIn, rand, mutPos);

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
        for (int i = 0; i < 2; i++) {
            int rx = pos.getX() + rand.nextInt(16) + 8;
            int ry = 55 + rand.nextInt(20);
            int rz = pos.getZ() + rand.nextInt(16) + 8;
            mutPos.setPos(rx, ry, rz);
            genTree.generate(worldIn, rand, mutPos);

            if (i == 0)
                genLargeTree.generate(worldIn, rand, mutPos);
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