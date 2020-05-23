package divinerpg.objects.blocks.twilight;

import divinerpg.DivineRPG;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

import java.util.Random;
import java.util.function.Supplier;

public class BlockModDoublePlant extends BlockBush
        implements IPlantable, net.minecraftforge.common.IShearable {
    public static final PropertyEnum<BlockModDoublePlant.EnumBlockHalf> HALF = PropertyEnum.create(
            "half", BlockModDoublePlant.EnumBlockHalf.class);
    protected static final AxisAlignedBB DOUBLE_PLANT_AABB = new AxisAlignedBB(0.1D, 0.0D, 0.1D, 0.9D, 1.0D, 0.9D);
    private Supplier<Block> grassSupplier;

    public BlockModDoublePlant(String name, Supplier<Block> grassSupplier, MapColor mapColorIn) {
        super(Material.PLANTS, mapColorIn);
        setRegistryName(DivineRPG.MODID, name);
        setUnlocalizedName(name);
        this.grassSupplier = grassSupplier;
        setCreativeTab(DivineRPGTabs.BlocksTab);
        this.setHardness(0.0F);
        this.setSoundType(SoundType.PLANT);
        this.setDefaultState(
                this.blockState.getBaseState().withProperty(HALF, BlockModDoublePlant.EnumBlockHalf.LOWER));
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return DOUBLE_PLANT_AABB;
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
        return this.getDefaultState();
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        IBlockState soil = worldIn.getBlockState(pos.down());
        return soil.getBlock() == grassSupplier.get() && worldIn.isAirBlock(pos) && worldIn.isAirBlock(pos.up());
    }

    @Override
    protected void checkAndDropBlock(World worldIn, BlockPos pos, IBlockState state) {
        if (!this.canBlockStay(worldIn, pos, state)) {
            breakBlock(worldIn, pos, state);
            spawnAsEntity(worldIn, pos, new ItemStack(Item.getItemFromBlock(this)));
        }
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
        if (state.getValue(HALF) == BlockModDoublePlant.EnumBlockHalf.UPPER) {
            worldIn.setBlockState(pos.down(), Blocks.AIR.getDefaultState(), 2);
        } else {
            worldIn.setBlockState(pos.up(), Blocks.AIR.getDefaultState(), 2);
        }
    }

    @Override
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
        if (state.getBlock() != this)
            return super.canBlockStay(worldIn, pos, state);
        if (state.getValue(HALF) == BlockModDoublePlant.EnumBlockHalf.UPPER) {
            return worldIn.getBlockState(pos.down()).getBlock() == this;
        } else {
            IBlockState iblockstate = worldIn.getBlockState(pos.up());
            return iblockstate.getBlock() == this && super.canBlockStay(worldIn, pos, iblockstate);
        }
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        if (state.getValue(HALF) == BlockModDoublePlant.EnumBlockHalf.LOWER) {
            worldIn.setBlockState(pos.up(),
                    this.getDefaultState().withProperty(HALF, BlockModDoublePlant.EnumBlockHalf.UPPER), 3);
        }
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Items.AIR;
    }

    @Override
    public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos) {
        return net.minecraftforge.common.EnumPlantType.Plains;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        if (meta > 0) {
            return this.getDefaultState().withProperty(HALF, BlockModDoublePlant.EnumBlockHalf.UPPER);
        } else {
            return this.getDefaultState().withProperty(HALF, BlockModDoublePlant.EnumBlockHalf.LOWER);
        }
    }

    @Override
    public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
        return true;
    }

    @Override
    public NonNullList<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        return NonNullList.withSize(1, new ItemStack(this, 1));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(HALF) == BlockModDoublePlant.EnumBlockHalf.UPPER ? 1 : 0;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, HALF);
    }

    public enum EnumBlockHalf implements IStringSerializable {
        UPPER, LOWER;
        public String toString() {
            return this.getName();
        }

        public String getName() {
            return this == UPPER ? "upper" : "lower";
        }
    }

    public Block getGrass(){
        return this.grassSupplier.get();
    }
}