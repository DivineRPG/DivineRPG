package naturix.divinerpg.dimensions.iceika;

import java.awt.Color;
import java.util.Random;

import naturix.divinerpg.dimensions.iceika.world.LargeFrozenTree;
import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeIceika extends Biome {

    private static BiomeProperties properties = new BiomeProperties("Iceika");
	private World world;
	private Random rand;
	private BlockPos pos;

    private final boolean enableSnow = true;
    private final boolean enableRain=true;
	public BiomeIceika(String name) {
	super(properties);
	this.topBlock = ModBlocks.grassIceika.getDefaultState();
	this.fillerBlock = ModBlocks.dirtIceika.getDefaultState();
    this.spawnableCreatureList.clear();
    this.spawnableMonsterList.clear();
    this.spawnableCaveCreatureList.clear();
    this.spawnableWaterCreatureList.clear();
    this.setRegistryName(name);
    this.flowers.clear();
    this.decorator.flowersPerChunk = 0;	
    this.decorator.grassPerChunk = 0;
    
    

    this.getSkyColorByTemp(Color.getHSBColor(0F, 25F, 111F).getRGB());
}

	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float par1) {
        return Color.getHSBColor(0F, 25F, 111F).getRGB();
}

	@Override
    public WorldGenAbstractTree getRandomTreeFeature(Random random) {
            return new LargeFrozenTree(false, 5);
        

    }
	
}