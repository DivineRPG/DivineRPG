package divinerpg.dimensions.wildwood;

import java.awt.Color;
import java.util.Random;

import divinerpg.Reference;
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

public class BiomeWildWood extends Biome {

    private static BiomeProperties properties = new BiomeProperties("WildWood");
    private World world;
    private Random rand;
    private BlockPos pos;

    public BiomeWildWood() {
        super(properties);
        this.setRegistryName(Reference.MODID, "wildwood");

        this.topBlock = ModBlocks.wildwoodGrass.getDefaultState();
        this.fillerBlock = ModBlocks.wildwoodDirt.getDefaultState();
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
        WildWoodTree genTree = new WildWoodTree(false, 5);
        LargeWildWoodTree genLargeTree = new LargeWildWoodTree(true, 5);
        WorldGenLakes genLakes = new WorldGenLakes(Blocks.WATER);
        WorldGenTwilightSinglePlants genMoonlightFern = new WorldGenTwilightSinglePlants(ModBlocks.moonlightFern,
                ModBlocks.wildwoodGrass);
        WorldGenTwilightSinglePlants genMoonBud = new WorldGenTwilightSinglePlants(ModBlocks.moonBud,
                ModBlocks.wildwoodGrass);
        WorldGenTwilightDoublePlants genWildwoodTallgrass = new WorldGenTwilightDoublePlants(
                ModBlocks.wildwoodTallgrass, ModBlocks.wildwoodGrass);

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
        for (int i = 0; i < 18; i++) {
            int rx = pos.getX() + rand.nextInt(16) + 8;
            int ry = 13 + rand.nextInt(80);
            int rz = pos.getZ() + rand.nextInt(16) + 8;
            mutPos.setPos(rx, ry, rz);
            genMoonlightFern.generate(worldIn, rand, mutPos);
        }
        for (int i = 0; i < 18; i++) {
            int rx = pos.getX() + rand.nextInt(16) + 8;
            int ry = 13 + rand.nextInt(80);
            int rz = pos.getZ() + rand.nextInt(16) + 8;
            mutPos.setPos(rx, ry, rz);
            genMoonBud.generate(worldIn, rand, mutPos);
        }
        for (int i = 0; i < 18; i++) {
            int rx = pos.getX() + rand.nextInt(16) + 8;
            int ry = 13 + rand.nextInt(80);
            int rz = pos.getZ() + rand.nextInt(16) + 8;
            mutPos.setPos(rx, ry, rz);
            genWildwoodTallgrass.generate(worldIn, rand, mutPos);
        }
    }
}