package divinerpg.objects.blocks;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

import divinerpg.objects.blocks.twilight.BlockBrambles;
import divinerpg.objects.blocks.twilight.BlockModDoublePlant;
import divinerpg.objects.blocks.twilight.BlockTwilightFlower;
import divinerpg.objects.items.base.ItemModSeeds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nonnull;

public abstract class BlockModGrass extends BlockMod implements IGrowable {

    protected ArrayList<Supplier<Block>> growablePlantsList = new ArrayList<Supplier<Block>>();
    protected Supplier<BlockModDirt> dirtSupplier;
    private MapColor mapColor;

    public BlockModGrass(String name, Supplier<BlockModDirt> dirtSupplier, float hardness,  @Nonnull MapColor mapColorIn) {
        super(name, hardness, Material.GRASS);
        this.setMapColor(mapColorIn);
        this.dirtSupplier = dirtSupplier;
        this.setHarvestLevel("shovel", 0);
        this.setTickRandomly(true);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(dirtSupplier.get());
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        if (!world.isRemote) {
            if (!world.isAreaLoaded(pos, 3))
                return;

            Block dirt = dirtSupplier.get();

            if (world.getLightFromNeighbors(pos.up()) < 4
                    && world.getBlockState(pos.up()).getLightOpacity(world, pos.up()) > 2) {
                world.setBlockState(pos, dirt.getDefaultState());
            } else {
                for (int l = 0; l < 4; ++l) {
                    BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
                    if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !world.isBlockLoaded(blockpos)) {
                        return;
                    }

                    IBlockState iblockstate = world.getBlockState(blockpos.up());
                    IBlockState iblockstate1 = world.getBlockState(blockpos);

                    if (iblockstate1.getBlock() == dirt && world.getLightFromNeighbors(blockpos.up()) >= 4
                            && iblockstate.getLightOpacity(world, pos.up()) <= 2) {
                        world.setBlockState(blockpos, this.getDefaultState());
                    }
                }
            }
        }
    }

    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return this.growablePlantsList.size() > 0;
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return this.growablePlantsList.size() > 0;
    }

    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        if(this.growablePlantsList.size() <= 0) {
            return;
        }

        BlockPos blockpos = pos.up();

        label35:
        for(int i = 0; i < 128; ++i) {
            BlockPos blockpos1 = blockpos;

            for(int j = 0; j < i / 16; ++j) {
                blockpos1 = blockpos1.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);
                if (worldIn.getBlockState(blockpos1.down()).getBlock() != this || worldIn.getBlockState(blockpos1).isNormalCube()) {
                    continue label35;
                }
            }

            if (worldIn.isAirBlock(blockpos1)) {
                Block flower = growablePlantsList.get(rand.nextInt(growablePlantsList.size())).get();
                if(flower != null && flower instanceof BlockBush) {
                    IBlockState flowerState = flower.getDefaultState();
                    //Currently doesn't actually plant tallgrass
                    if(((BlockBush)flower).canBlockStay(worldIn, blockpos1, flowerState)) {
                        worldIn.setBlockState(blockpos1, flowerState, 3);
                        System.out.println(blockpos1);
                    }
                }
            }
        }
    }

    protected void addGrowablePlant(Supplier<Block> blockSupplier) {
        this.growablePlantsList.add(blockSupplier);
    }

    @Override
    public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction,
            IPlantable plantable) {

        if (plantable instanceof BlockModCrop) {
            // get itemStack with seed from plants
            ItemStack item = ((BlockModCrop) plantable).getItem(((World) world), pos, state);
            if (item != null) {
                // getting seed
                Item seed = item.getItem();
                // If seed is Divine type, reset local value
                // Condition below will handle it
                if (seed instanceof ItemModSeeds) {
                    plantable = (ItemModSeeds) seed;
                }
            }
        }

        if (plantable instanceof BlockModDoublePlant) {
            return ((BlockModDoublePlant) plantable).getGrass() == this;
        }

        if (plantable instanceof BlockBrambles) {
            return ((BlockBrambles) plantable).getGrass() == this;
        }
        if (plantable instanceof BlockTwilightFlower) {
            return ((BlockTwilightFlower) plantable).getGrass() == this;
        }

        if (plantable instanceof ItemModSeeds) {
            return ((ItemModSeeds)plantable).soilSupplier.get() == this;
        }

        return false;
    }

    /**
     * Defensive helper method used to intercept null map colors.
     * Private access used to force the map color to be included in the constructor.
     *
     * @param mapColorIn the map color to set
     */
    private void setMapColor(MapColor mapColorIn) {
        if(mapColorIn == null) {
            this.mapColor = Material.GRASS.getMaterialMapColor();
        }
        else {
            this.mapColor = mapColorIn;
        }
    }

    /**
     * Tells maps to use the map color we set.
     *
     * @param state the blockstate
     * @param worldIn the world
     * @param pos the block position
     * @return the map color
     */
    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return this.mapColor;
    }


}
