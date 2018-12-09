package naturix.divinerpg.dimensions.eden;

import java.awt.Color;
import java.util.Random;

import naturix.divinerpg.entities.entity.arcana.EdenCadillion;
import naturix.divinerpg.entities.entity.arcana.EdenCori;
import naturix.divinerpg.entities.entity.arcana.EdenTomo;
import naturix.divinerpg.entities.entity.twilight.Bunny;
import naturix.divinerpg.entities.entity.twilight.Greenfeet;
import naturix.divinerpg.entities.entity.twilight.Madivel;
import naturix.divinerpg.entities.entity.twilight.SunArcher;
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
    this.flowers.clear();
    this.decorator.flowersPerChunk = 0;	
    this.decorator.grassPerChunk = 0;
    
    this.spawnableMonsterList.add(new SpawnListEntry(EdenCadillion.class, 1, 1, 1));
    this.spawnableMonsterList.add(new SpawnListEntry(EdenTomo.class, 1, 1, 1));
    this.spawnableMonsterList.add(new SpawnListEntry(Bunny.class, 1, 1, 1));
    this.spawnableMonsterList.add(new SpawnListEntry(EdenCori.class, 1, 1, 1));
    this.spawnableMonsterList.add(new SpawnListEntry(Greenfeet.class, 1, 1, 1));
    this.spawnableMonsterList.add(new SpawnListEntry(Madivel.class, 1, 1, 1));
    this.spawnableMonsterList.add(new SpawnListEntry(SunArcher.class, 1, 1, 1));
    

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
            return new EdenAbstractTree(false, 5);
        } else {
            return new LargeEdenAbstractTree(true, 5, ModBlocks.edenLog.getDefaultState(), ModBlocks.edenLeaves.getDefaultState());
        }

    }
	

	
}