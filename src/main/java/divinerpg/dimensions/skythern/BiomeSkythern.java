package divinerpg.dimensions.skythern;

import divinerpg.dimensions.TwilightBiomeBase;
import divinerpg.dimensions.TwilightTree;
import divinerpg.dimensions.WorldGenPlants;
import divinerpg.dimensions.eden.WorldGenConeUp;
import divinerpg.registry.BlockRegistry;
import divinerpg.world.features.WorldGenTwilightDoublePlants;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;

public class BiomeSkythern extends TwilightBiomeBase {

    public BiomeSkythern() {
        super(new BiomeProperties("Skythern"), "skythern");

        this.genTree = new TwilightTree(false, 5,
                () -> BlockRegistry.skythernLog.getDefaultState(),
                () -> BlockRegistry.skythernLeaves.getDefaultState(),
                () -> BlockRegistry.skythernSapling);
        this.genLargeTree = new SkythernTreeLarge(true, 5);
        this.genConeUp = new WorldGenConeUp(BlockRegistry.divineMossStone);
        this.brush = new WorldGenPlants(BlockRegistry.skythernBrush, BlockRegistry.skythernGrass);
        this.bloom = new WorldGenPlants(BlockRegistry.dustLily, BlockRegistry.skythernGrass);
        this.blossom = new WorldGenTwilightDoublePlants(BlockRegistry.dustBrambles,
                BlockRegistry.skythernGrass);

        this.topBlock = BlockRegistry.skythernGrass.getDefaultState();
        this.fillerBlock = BlockRegistry.skythernDirt.getDefaultState();
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