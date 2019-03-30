package naturix.divinerpg.world.biomes;

import java.awt.Color;
import java.util.Random;

import naturix.divinerpg.dimensions.eden.worldgen.features.WorldGenConeUp;
import naturix.divinerpg.dimensions.eden.worldgen.trees.EdenAbstractTree;
import naturix.divinerpg.dimensions.eden.worldgen.trees.LargeEdenAbstractTree;
import naturix.divinerpg.objects.entities.entity.twilight.EdenCadillion;
import naturix.divinerpg.objects.entities.entity.twilight.EdenCori;
import naturix.divinerpg.objects.entities.entity.twilight.EdenTomo;
import naturix.divinerpg.objects.entities.entity.twilight.Bunny;
import naturix.divinerpg.objects.entities.entity.twilight.Greenfeet;
import naturix.divinerpg.objects.entities.entity.twilight.Madivel;
import naturix.divinerpg.objects.entities.entity.twilight.SunArcher;
import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeEden extends Biome {

    private static BiomeProperties properties = new BiomeProperties("eden");
    private World world;
    private Random rand;
    private BlockPos pos;

    public BiomeEden() {
        super(properties);
        this.topBlock = ModBlocks.edenGrass.getDefaultState();
        this.fillerBlock = ModBlocks.edenDirt.getDefaultState();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
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
    public void decorate(World worldIn, Random rand, BlockPos pos) {
        EdenAbstractTree genTree = new EdenAbstractTree(false, 3);
        LargeEdenAbstractTree genLargeTree = new LargeEdenAbstractTree(false, 7, ModBlocks.edenLogs.getDefaultState(),
                ModBlocks.edenLeaves.getDefaultState());
        WorldGenConeUp genConeUp = new WorldGenConeUp(ModBlocks.divineMossystone);
        WorldGenLakes genLakes = new WorldGenLakes(Blocks.WATER);

        BlockPos.MutableBlockPos mutPos = new BlockPos.MutableBlockPos(0, 0, 0);
        for (int i = 0; i < 40; i++) {
            int rx = pos.getX() + rand.nextInt(16) + 8;
            int ry = 13 + rand.nextInt(80);
            int rz = pos.getZ() + rand.nextInt(16) + 8;
            mutPos.setPos(rx, ry, rz);
            genLargeTree.generate(worldIn, rand, mutPos);
        }
        for (int i = 0; i < 10; i++) {
            int rx = pos.getX() + rand.nextInt(16) + 8;
            int ry = 55 + rand.nextInt(20);
            int rz = pos.getZ() + rand.nextInt(16) + 8;
            mutPos.setPos(rx, ry, rz);
            genTree.generate(worldIn, rand, mutPos);
        }
        for (int i = 0; i < 1; i++) {
            int rx = pos.getX() + rand.nextInt(16) + 8;
            int ry = 55 + rand.nextInt(20);
            int rz = pos.getZ() + rand.nextInt(16) + 8;
            mutPos.setPos(rx, ry, rz);
            genLakes.generate(worldIn, rand, mutPos);
        }

        for (int i = 0; i < 1; i++) {
            int rx = pos.getX() + rand.nextInt(16) + 8;
            int ry = 55 + rand.nextInt(20);
            int rz = pos.getZ() + rand.nextInt(16) + 8;
            mutPos.setPos(rx, ry, rz);
            if (rand.nextInt(10) == 1) {
                genConeUp.generate(worldIn, rand, mutPos);
            }
        }
    }
}