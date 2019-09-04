package divinerpg.dimensions.skythern;

import divinerpg.dimensions.TwilightBiomeBase;
import divinerpg.dimensions.eden.WorldGenConeUp;
import divinerpg.registry.ModBlocks;
import divinerpg.world.features.WorldGenTwilightDoublePlants;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;
import java.util.Random;

public class BiomeSkythern extends TwilightBiomeBase {

    protected WorldGenerator genLargeTreeTruffle;

    public BiomeSkythern() {
        super(new BiomeProperties("Skythern"), "skythern");

        this.genTree = new SkythernTree(false, 5);
        this.genLargeTree = new SkythernTreeLarge(true, 5);
        this.genLargeTreeTruffle = new SkythernTreeLargeTruffle(true, 5);
        this.genConeUp = new WorldGenConeUp(ModBlocks.divineMossystone);
        this.brush = new WorldGenSkythernPlants(ModBlocks.skythernBrush);
        this.bloom = new WorldGenSkythernPlants(ModBlocks.dustLily);
        this.blossom = new WorldGenTwilightDoublePlants(ModBlocks.dustBrambles,
                ModBlocks.skythernGrass);

        this.topBlock = ModBlocks.skythernGrass.getDefaultState();
        this.fillerBlock = ModBlocks.skythernDirt.getDefaultState();
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
        super.decorate(worldIn, rand, pos);

        generate(worldIn, rand, this.chunk.x, this.chunk.z, 5, 13, 13 + 80, genLargeTreeTruffle);
    }
}