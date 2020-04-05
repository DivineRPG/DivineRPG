package divinerpg.dimensions.apalachia;

import divinerpg.dimensions.TwilightBiomeBase;
import divinerpg.dimensions.TwilightTree;
import divinerpg.registry.ModBlocks;
import divinerpg.world.features.WorldGenTwilightDoublePlants;
import divinerpg.world.features.WorldGenTwilightSinglePlants;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;
import java.util.Random;

public class BiomeApalachia extends TwilightBiomeBase {

    public BiomeApalachia() {
        super(new BiomeProperties("Apalachia"), "apalachia");

        genTree = new TwilightTree(false, 5,
                () -> ModBlocks.apalachiaLog.getDefaultState(),
                () -> ModBlocks.apalachiaLeaves.getDefaultState(),
                () -> ModBlocks.apalachiaSapling);
        genLargeTree = new ApalachiaTreeLarge(true, 5);
        genLakes = new WorldGenLakes(Blocks.WATER);
        blossom = new WorldGenTwilightDoublePlants(ModBlocks.duskFlower,
                ModBlocks.apalachiaGrass);
        brush = new WorldGenTwilightSinglePlants(ModBlocks.apalachiaTallgrass,
                ModBlocks.apalachiaGrass);
        bloom = new WorldGenTwilightSinglePlants(ModBlocks.duskBloom,
                ModBlocks.apalachiaGrass);

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
        this.chunk = worldIn.getChunkFromBlockCoords(pos);

        generate(worldIn, rand, chunk.x, chunk.z, 40, 13, 80 + 13, genLargeTree);

        generate(worldIn, rand, chunk.x, chunk.z, 30, 13, 80 + 13,
                genTree);

        generate(worldIn, rand, chunk.x, chunk.z, 1, 55, 55 + 20,
                genLakes);

        generate(worldIn, rand, chunk.x, chunk.z, 12, 13, 80 + 13,
                bloom, blossom);

        generate(worldIn, rand, chunk.x, chunk.z, 20, 13, 80 + 13,
                brush);
    }
}