package naturix.divinerpg.world.biomes;

import java.awt.Color;
import java.util.Random;

import naturix.divinerpg.dimensions.mortum.worldgen.trees.MortumTree;
import naturix.divinerpg.dimensions.mortum.worldgen.trees.MortumTreeLarge;
import naturix.divinerpg.registry.ModBlocks;
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

        this.getSkyColorByTemp(Color.getHSBColor(0.1361F, 0.95F, 1.0F).getRGB());
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float par1) {
        return Color.getHSBColor(0.1361F, 0.95F, 1.0F).getRGB();
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random random) {
        if (random.nextInt(5) == 0) {
            return new MortumTree(false, 5);
        } else {
            return new MortumTreeLarge(false, 7);
        }
    }
}