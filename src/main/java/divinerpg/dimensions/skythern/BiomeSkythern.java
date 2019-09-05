package divinerpg.dimensions.skythern;

import divinerpg.dimensions.TwilightBiomeBase;
import divinerpg.dimensions.WorldGenPlants;
import divinerpg.dimensions.eden.WorldGenConeUp;
import divinerpg.registry.ModBlocks;
import divinerpg.world.features.WorldGenTwilightDoublePlants;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;

public class BiomeSkythern extends TwilightBiomeBase {

    public BiomeSkythern() {
        super(new BiomeProperties("Skythern"), "skythern");

        this.genTree = new SkythernTree(false, 5);
        this.genLargeTree = new SkythernTreeLarge(true, 5);
        this.genConeUp = new WorldGenConeUp(ModBlocks.divineMossystone);
        this.brush = new WorldGenPlants(ModBlocks.skythernBrush, ModBlocks.skythernGrass);
        this.bloom = new WorldGenPlants(ModBlocks.dustLily, ModBlocks.skythernGrass);
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
}