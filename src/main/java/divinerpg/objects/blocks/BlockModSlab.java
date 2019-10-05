package divinerpg.objects.blocks;

import java.util.Random;

import divinerpg.api.java.divinerpg.api.Reference;
import divinerpg.enums.WoodType;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class BlockModSlab extends BlockSlab  {
    public static final PropertyEnum<WoodType> VARIANT = PropertyEnum.<WoodType>create("variant", WoodType.class);

    private Block single;
    private WoodType woodType;

    public BlockModSlab(BlockModPlank plank, Block single, WoodType woodType) {
        super(Material.WOOD, woodType.getMapColor());
        setHardness(plank.getWoodType().getHardness());
        setResistance(5);

        String name = woodType.getName() + (isDouble() ? "_double_slab" : "_slab");
        setUnlocalizedName(name);
        setRegistryName(Reference.MODID, name);

        this.single = single;
        this.woodType = woodType;
        if (this.isDouble()) {
            setDefaultState(this.blockState.getBaseState().withProperty(this.getVariantProperty(), woodType));
        } else {
            useNeighborBrightness = true;
            setDefaultState(this.blockState.getBaseState().withProperty(this.getVariantProperty(), woodType)
                    .withProperty(HALF, EnumBlockHalf.BOTTOM));
            setCreativeTab(DivineRPGTabs.BlocksTab);
        }

        ModBlocks.BLOCKS.add(this);
    }

    public String getUnlocalizedName(int meta) {
        return super.getUnlocalizedName();
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
            float hitZ, int meta, EntityLivingBase placer) {
        IBlockState iblockstate = this.getDefaultState();

        if (this.isDouble()) {
            return iblockstate;
        } else {
            return facing != EnumFacing.DOWN && (facing == EnumFacing.UP || (double) hitY <= 0.5D) ? iblockstate :
                    iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.TOP);
        }
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return this.isDouble() ? new BlockStateContainer(this, this.getVariantProperty()) :
                new BlockStateContainer(this, this.getVariantProperty(), HALF);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(getSingle());
    }

    @Override
    @SuppressWarnings("deprecation")
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(Item.getItemFromBlock(getSingle()));
    }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        return this.isDouble() ? this.getDefaultState() :
                this.getDefaultState().withProperty(HALF, meta == 0 ? EnumBlockHalf.BOTTOM : EnumBlockHalf.TOP);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return this.isDouble() ? 0 : state.getValue(HALF) == EnumBlockHalf.BOTTOM ? 0 : 1;
    }

    @Override
    public abstract boolean isDouble();

    @Override
    public abstract IProperty<WoodType> getVariantProperty();

    @Override
    public Comparable<WoodType> getTypeForItem(ItemStack stack) {
        return woodType;
    }

    protected abstract Block getSingle();
}
