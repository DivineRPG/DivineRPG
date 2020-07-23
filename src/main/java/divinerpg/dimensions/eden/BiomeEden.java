package divinerpg.dimensions.eden;

import divinerpg.dimensions.LargeTwilightTree;
import divinerpg.dimensions.TwilightBiomeBase;
import divinerpg.registry.BlockRegistry;
import divinerpg.world.features.WorldGenTwilightSinglePlants;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;

public class BiomeEden extends TwilightBiomeBase {

    public BiomeEden() {
        super(new BiomeProperties("Eden"), "eden");

        this.genTree = new EdenTree(false, 3);
        this.genLargeTree = new LargeTwilightTree(false, 7,
                BlockRegistry.edenLog.getDefaultState(),
                BlockRegistry.edenLeaves.getDefaultState(),
                BlockRegistry.edenGrass);
        this.genConeUp = new WorldGenConeUp(BlockRegistry.divineMossStone);
        this.genLakes = new WorldGenLakes(Blocks.WATER);
        this.brush = new WorldGenTwilightSinglePlants(BlockRegistry.edenBrush, BlockRegistry.edenGrass);
        this.bloom = new WorldGenTwilightSinglePlants(BlockRegistry.sunbloom, BlockRegistry.edenGrass);
        this.blossom = new WorldGenTwilightSinglePlants(BlockRegistry.sunBlossom,
                BlockRegistry.edenGrass);

        this.topBlock = BlockRegistry.edenGrass.getDefaultState();
        this.fillerBlock = BlockRegistry.edenDirt.getDefaultState();
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