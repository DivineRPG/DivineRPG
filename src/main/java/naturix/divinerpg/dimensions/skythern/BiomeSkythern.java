package naturix.divinerpg.dimensions.skythern;

import java.awt.Color;
import java.util.Random;

import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeSkythern extends Biome {

    private static BiomeProperties properties = new BiomeProperties("Skythern");
	private World world;
	private Random rand;
	private BlockPos pos;
	public BiomeSkythern(String name) {
	super(properties);
	this.topBlock = ModBlocks.grassSkythern.getDefaultState();
	this.fillerBlock = ModBlocks.dirtSkythern.getDefaultState();
    this.spawnableCreatureList.clear();
    this.spawnableMonsterList.clear();
    this.spawnableCaveCreatureList.clear();
    this.spawnableWaterCreatureList.clear();
    this.setRegistryName(name);
    this.flowers.clear();
    this.decorator.flowersPerChunk = 0;	
    this.decorator.grassPerChunk = 0;


//    this.getSkyColorByTemp(Color.getHSBColor(0.1361F, 0.95F, 1.0F).getRGB());
}

	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float par1) {
        return Color.getHSBColor(0.1361F, 0.95F, 1.0F).getRGB();
}
	@Override
    public WorldGenAbstractTree getRandomTreeFeature(Random random) {
		if (random.nextInt(5) == 0) {
            return new SkythernTree(false, 5);
        } else {
            return new SkythernTreeLarge(true, 5);
        }

    }
	

	
}