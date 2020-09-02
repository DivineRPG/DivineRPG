package divinerpg.dimensions.mortum;

import divinerpg.dimensions.TwilightBiomeBase;
import divinerpg.dimensions.WorldGenPlants;
import divinerpg.dimensions.eden.WorldGenConeUp;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.StructureRegistry;
import divinerpg.structure.base.DRPGStructureHandler;
import divinerpg.world.features.WorldGenTwilightDoublePlants;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;
import java.util.Random;

public class BiomeMortum extends TwilightBiomeBase {

    public BiomeMortum() {
        super(new BiomeProperties("Mortum"), "mortum");

        this.genTree = new MortumTree(false, 5);
        this.genLargeTree = new MortumTreeLarge(true, 5);
        this.genConeUp = new WorldGenConeUp(BlockRegistry.divineMossStone);
        this.brush = new WorldGenPlants(BlockRegistry.mortumBrush, BlockRegistry.mortumGrass);
        this.bloom = new WorldGenPlants(BlockRegistry.eyePlant, BlockRegistry.mortumGrass);
        this.blossom = new WorldGenTwilightDoublePlants(BlockRegistry.demonBrambles, BlockRegistry.mortumGrass);

        this.topBlock = BlockRegistry.mortumGrass.getDefaultState();
        this.fillerBlock = BlockRegistry.mortumDirt.getDefaultState();
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

    @Override
    public void decorate(World worldIn, Random rand, BlockPos pos) {
    	int currentX = pos.getX();
        int currentZ = pos.getZ();

        for(int k = 0; k < rand.nextInt(40000); k++) {
            int x = currentX + rand.nextInt(8) + 8;
            int z = currentZ + rand.nextInt(8) + 8;
            int y = rand.nextInt(worldIn.getHeight());
            BlockPos structPos = new BlockPos(x, y, z);
            if(worldIn.getBlockState(structPos.down()) == BlockRegistry.mortumGrass.getDefaultState() && worldIn.isAirBlock(structPos)) {
            bloom.generate(worldIn, rand, structPos);
            }
        }
        for(int k = 0; k < rand.nextInt(100000); k++) {
            int x = currentX + rand.nextInt(8) + 8;
            int z = currentZ + rand.nextInt(8) + 8;
            int y = rand.nextInt(worldIn.getHeight());
            BlockPos structPos = new BlockPos(x, y, z);
            if(worldIn.getBlockState(structPos.down()) == BlockRegistry.mortumGrass.getDefaultState() && worldIn.isAirBlock(structPos)) {
            	brush.generate(worldIn, rand, structPos);
            	blossom.generate(worldIn, rand, structPos);
            }
        }
        for(int k = 0; k < rand.nextInt(10000); k++) {
            int x = currentX + rand.nextInt(8) + 8;
            int z = currentZ + rand.nextInt(8) + 8;
            int y = rand.nextInt(worldIn.getHeight());
            BlockPos structPos = new BlockPos(x, y, z);
            if(worldIn.getBlockState(structPos.down()) == BlockRegistry.mortumGrass.getDefaultState() && worldIn.isAirBlock(structPos)) {
            brush.generate(worldIn, rand, structPos);
            }
        }
        for(int k = 0; k < rand.nextInt(80); k++) {
            int x = currentX + rand.nextInt(8) + 8;
            int z = currentZ + rand.nextInt(8) + 8;
            int y = rand.nextInt(worldIn.getHeight());
            BlockPos structPos = new BlockPos(x, y, z);
            if(worldIn.getBlockState(structPos.down()) == BlockRegistry.mortumGrass.getDefaultState() && worldIn.isAirBlock(structPos.up(8))) {
            genTree.generate(worldIn, rand, structPos);
            }
        }
        for(int k = 0; k < rand.nextInt(80); k++) {
            int x = currentX + rand.nextInt(8) + 8;
            int z = currentZ + rand.nextInt(8) + 8;
            int y = rand.nextInt(worldIn.getHeight());
            BlockPos structPos = new BlockPos(x, y, z);
            if(worldIn.getBlockState(structPos.down()) == BlockRegistry.mortumGrass.getDefaultState() && worldIn.isAirBlock(structPos.up(8))) {
            	genLargeTree.generate(worldIn, rand, structPos);
            	genConeUp.generate(worldIn, rand, structPos);
            }
        }
        
        for(int k = 0; k < rand.nextInt(99); k++) {
            int x = currentX + rand.nextInt(8) + 8;
            int z = currentZ + rand.nextInt(8) + 8;
            int y = rand.nextInt(worldIn.getHeight());
            BlockPos structPos = new BlockPos(x, y, z);
            if(worldIn.getBlockState(structPos.down()).getBlock() == BlockRegistry.mortumGrass && worldIn.getBlockState(structPos).getBlock() == Blocks.AIR || worldIn.getBlockState(structPos.down()).getBlock() == BlockRegistry.mortumDirt && worldIn.getBlockState(structPos).getBlock() == Blocks.AIR) {
                int listSize = StructureRegistry.MORTUM_SMALL_STRUCTURES.size();
                DRPGStructureHandler structure = StructureRegistry.MORTUM_SMALL_STRUCTURES.get(rand.nextInt(listSize));
                structure.generate(worldIn, rand, structPos);
            }
        }
    }
}