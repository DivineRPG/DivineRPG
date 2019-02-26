package naturix.divinerpg.world.biomes;

import naturix.divinerpg.dimensions.wildwood.worldgen.trees.LargeWildWoodTree;
import naturix.divinerpg.dimensions.wildwood.worldgen.trees.WildWoodTree;
import naturix.divinerpg.objects.entities.entity.twilight.*;
import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;
import java.util.Random;

public class BiomeWildWood extends Biome {

    private static BiomeProperties properties = new BiomeProperties("WildWood");
	private World world;
	private Random rand;
	private BlockPos pos;
	
	public BiomeWildWood() {
	super(properties);
	//this.topBlock = ModBlocks.grassWild.getDefaultState();
	//this.fillerBlock = ModBlocks.dirtWild.getDefaultState();
    this.spawnableCreatureList.clear();
    this.spawnableMonsterList.clear();
    this.spawnableCaveCreatureList.clear();
    this.spawnableWaterCreatureList.clear();
    this.flowers.clear();
    this.decorator.flowersPerChunk = 0;	
    this.decorator.grassPerChunk = 0;
    
    this.spawnableMonsterList.add(new SpawnListEntry(WildwoodCadillion.class, 1, 1, 1));
    this.spawnableMonsterList.add(new SpawnListEntry(WildwoodTomo.class, 1, 1, 1));
    this.spawnableMonsterList.add(new SpawnListEntry(WildwoodGolem.class, 1, 1, 1));
    this.spawnableMonsterList.add(new SpawnListEntry(WildwoodWolf.class, 1, 1, 1));
    this.spawnableMonsterList.add(new SpawnListEntry(Epiphite.class, 1, 1, 1));
    this.spawnableMonsterList.add(new SpawnListEntry(Bohemoth.class, 1, 1, 1));
    this.spawnableMonsterList.add(new SpawnListEntry(Verek.class, 1, 1, 1));
    this.spawnableMonsterList.add(new SpawnListEntry(Mage.class, 1, 1, 1));
    this.spawnableMonsterList.add(new SpawnListEntry(MoonWolf.class, 1, 1, 1));
    
    
	
	
    this.decorator.treesPerChunk = 6;
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
            return new WildWoodTree(false, 5);
        } else {
            return new LargeWildWoodTree(true, 5);
        }
	}
}