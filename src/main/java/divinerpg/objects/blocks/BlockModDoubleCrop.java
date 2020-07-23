package divinerpg.objects.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockModDoubleCrop extends BlockMod implements IPlantable {
    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 2);
    protected static final AxisAlignedBB TALL_CROP_AABB = new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 1.0D, 0.875D);
    private Random rand;

    public BlockModDoubleCrop(String name) {
        super(name, 0F, Material.PLANTS);
        this.setTickRandomly(true);
        setCreativeTab(null);
        this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)));

        this.rand = new Random();
    }

    abstract public Item getSeedDrop();

    abstract public Item getFlowerDrop();

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return TALL_CROP_AABB;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (worldIn.isAirBlock(pos.up()) && ((Integer) state.getValue(AGE)).intValue() == 0
                && worldIn.getBlockState(pos.down()).getMaterial() == Material.GRASS) {
            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, true)) {
                worldIn.setBlockState(pos.up(), state.withProperty(AGE, Integer.valueOf(2)));
                worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(1)));
                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
            }
        }
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        IBlockState state = worldIn.getBlockState(pos.down());
        Block block = state.getBlock();
        return block == this || state.getMaterial() == Material.GRASS;
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        if (!this.canPlaceBlockAt(worldIn, pos)) {
            if (((Integer) state.getValue(AGE)).intValue() == 2) {
                this.dropBlockAsItem(worldIn, pos, state, 0);
            } else if (((Integer) state.getValue(AGE)).intValue() == 0) {
                this.spawnAsEntity(worldIn, pos, new ItemStack(getSeedDrop()));
            }
            worldIn.destroyBlock(pos, false);
        } else {
            if (((Integer) state.getValue(AGE)).intValue() == 1 && pos.up().equals(fromPos)) {
                worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(0)));
            }
        }
    }

    @Override
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return NULL_AABB;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return getSeedDrop();
    }

    @Override
    public int quantityDropped(Random rand) {
        return 1 + rand.nextInt(2);
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state,
            int fortune) {
        int age = ((Integer) state.getValue(AGE)).intValue();
        if (age == 0) {
            drops.add(new ItemStack(this.getItemDropped(state, this.rand, 0), 1));
        } else if (age == 1) {
            drops.add(new ItemStack(this.getItemDropped(state, this.rand, 0), this.quantityDropped(this.rand)));
        } else if (age == 2) {
            drops.add(new ItemStack(getFlowerDrop(), 1));
        }
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(getSeedDrop());
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(AGE, Integer.valueOf(meta));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((Integer) state.getValue(AGE)).intValue();
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
        return this.getDefaultState();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] { AGE });
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }
}