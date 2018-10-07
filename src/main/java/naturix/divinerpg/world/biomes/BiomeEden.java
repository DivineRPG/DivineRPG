package naturix.divinerpg.world.biomes;

import java.awt.Color;
import java.util.Random;

import naturix.divinerpg.dimensions.eden.EdenAbstractTree;
import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeEden extends Biome {

    private static BiomeProperties properties = new BiomeProperties("eden");
	private World world;
	private Random rand;
	private BlockPos pos;
	public BiomeEden(String name) {
	super(properties);
	this.topBlock = ModBlocks.grassEden.getDefaultState();
	this.fillerBlock = ModBlocks.dirtEden.getDefaultState();
    this.spawnableCreatureList.clear();
    this.spawnableMonsterList.clear();
    this.spawnableCaveCreatureList.clear();
    this.spawnableWaterCreatureList.clear();
    this.setRegistryName(name);
    this.addDefaultFlowers();
    
//    this.decorator.treesPerChunk = 6;
    this.getSkyColorByTemp(Color.getHSBColor(0.1361F, 0.95F, 1.0F).getRGB());
    //this.waterColorMultiplier = 2368548;
}

	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float par1) {
        return Color.getHSBColor(0.1361F, 0.95F, 1.0F).getRGB();
}
	@Override
    public WorldGenAbstractTree getRandomTreeFeature(Random random) {
        if (random.nextInt(5) == 0) {
            return new EdenAbstractTree(false, 5);
        } else {
            return new EdenAbstractTree(true);
        }
    }
	
	
}