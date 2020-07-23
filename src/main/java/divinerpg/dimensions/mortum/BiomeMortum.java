package divinerpg.dimensions.mortum;

import divinerpg.dimensions.TwilightBiomeBase;
import divinerpg.dimensions.WorldGenPlants;
import divinerpg.dimensions.eden.WorldGenConeUp;
import divinerpg.registry.BlockRegistry;
import divinerpg.world.features.WorldGenTwilightDoublePlants;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;
import java.util.Random;

public class BiomeMortum extends TwilightBiomeBase {

    public BiomeMortum() {
        super(new BiomeProperties("Mortum"), "mortum");

        this.genTree = new MortumTree(false, 5);
        this.genLargeTree = new MortumTreeLarge(true, 5);
        this.genConeUp = new WorldGenConeUp(BlockRegistry.divineMossStone);
        this.brush = new WorldGenPlants(BlockRegistry.mortumBrush, BlockRegistry.mortumGrass);
        this.bloom = new WorldGenPlants(BlockRegistry.eyePlant, BlockRegistry.mortumGrass);
        this.blossom = new WorldGenTwilightDoublePlants(BlockRegistry.demonBrambles, BlockRegistry.mortumGrass);

        this.topBlock = BlockRegistry.mortumGrass.getDefaultState();
        this.fillerBlock = BlockRegistry.mortumDirt.getDefaultState();
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
        this.chunk = worldIn.getChunkFromBlockCoords(pos);

        generate(worldIn, rand, chunk.x, chunk.z, 40, 13, 80 + 13, bloom);

        generate(worldIn, rand, chunk.x, chunk.z, 10, 13, 80 + 13,
                brush, blossom);


        generate(worldIn, rand, chunk.x, chunk.z, 100, 13, 80 + 13,
                brush);

        generate(worldIn, rand, chunk.x, chunk.z, 5, 55, 55 + 20,
                genTree);

        generate(worldIn, rand, chunk.x, chunk.z, 1, 55, 55 + 20,
                genLargeTree, genConeUp);
    }
}