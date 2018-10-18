package naturix.divinerpg.dimensions.wildwood;

import java.awt.Color;
import java.util.Random;

import naturix.divinerpg.entities.entity.twilight.Bunny;
import naturix.divinerpg.entities.entity.twilight.Greenfeet;
import naturix.divinerpg.entities.entity.twilight.Madivel;
import naturix.divinerpg.entities.entity.twilight.SunArcher;
import naturix.divinerpg.entities.entity.twilight.WildwoodCadillion;
import naturix.divinerpg.entities.entity.twilight.WildwoodGolem;
import naturix.divinerpg.entities.entity.twilight.WildwoodTomo;
import naturix.divinerpg.entities.entity.twilight.WildwoodWolf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeWildWood extends Biome {

    private static BiomeProperties properties = new BiomeProperties("WildWood");
	private World world;
	private Random rand;
	private BlockPos pos;
	public BiomeWildWood(String name) {
	super(properties);
//	this.topBlock = ModBlocks.grassWildWood.getDefaultState();
//	this.fillerBlock = ModBlocks.dirtWildWood.getDefaultState();
    this.spawnableCreatureList.clear();
    this.spawnableMonsterList.clear();
    this.spawnableCaveCreatureList.clear();
    this.spawnableWaterCreatureList.clear();
    this.setRegistryName(name);

    this.spawnableMonsterList.add(new SpawnListEntry(WildwoodCadillion.class, 1, 1, 1));
    this.spawnableMonsterList.add(new SpawnListEntry(WildwoodTomo.class, 1, 1, 1));
    this.spawnableMonsterList.add(new SpawnListEntry(Bunny.class, 1, 1, 1));
    this.spawnableMonsterList.add(new SpawnListEntry(WildwoodGolem.class, 1, 1, 1));
    this.spawnableMonsterList.add(new SpawnListEntry(WildwoodWolf.class, 1, 1, 1));
    this.spawnableMonsterList.add(new SpawnListEntry(Greenfeet.class, 1, 1, 1));
    this.spawnableMonsterList.add(new SpawnListEntry(Madivel.class, 1, 1, 1));
    this.spawnableMonsterList.add(new SpawnListEntry(SunArcher.class, 1, 1, 1));
    
	
	
	
	
//    this.decorator.treesPerChunk = 6;
    this.getSkyColorByTemp(Color.getHSBColor(0.1361F, 0.95F, 1.0F).getRGB());
    //this.waterColorMultiplier = 2368548;
}

	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float par1) {
        return Color.getHSBColor(0.1361F, 0.95F, 1.0F).getRGB();
}
//	@Override
//    public WorldGenAbstractTree getRandomTreeFeature(Random random) {
//		if (random.nextInt(5) == 0) {
//            return new WildWoodAbstractTree(false, 5);
//        } else {
//            return new LargeWildWoodAbstractTree(true, 5, ModBlocks.WildWoodLog.getDefaultState(), ModBlocks.WildWoodLeaves.getDefaultState());
//        }
//
//    }
	
	
}