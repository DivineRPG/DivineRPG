package divinerpg.dimensions.eden;

import divinerpg.dimensions.TwilightBiomeBase;
import divinerpg.registry.ModBlocks;
import divinerpg.world.features.WorldGenTwilightSinglePlants;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;

public class BiomeEden extends TwilightBiomeBase {

    public BiomeEden() {
        super(new BiomeProperties("eden"), "eden");

        this.genTree = new EdenTree(false, 3);
        this.genLargeTree = new LargeEdenTree(false, 7, ModBlocks.edenLog.getDefaultState(),
                ModBlocks.edenLeaves.getDefaultState());
        this.genConeUp = new WorldGenConeUp(ModBlocks.divineMossStone);
        this.genLakes = new WorldGenLakes(Blocks.WATER);
        this.brush = new WorldGenTwilightSinglePlants(ModBlocks.edenBrush, ModBlocks.edenGrass);
        this.bloom = new WorldGenTwilightSinglePlants(ModBlocks.sunbloom, ModBlocks.edenGrass);
        this.blossom = new WorldGenTwilightSinglePlants(ModBlocks.sunBlossom,
                ModBlocks.edenGrass);

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

}