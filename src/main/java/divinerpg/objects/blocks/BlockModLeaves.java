package divinerpg.objects.blocks;

import java.util.Random;

import divinerpg.Reference;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

public class BlockModLeaves extends BlockLeaves implements IShearable {
    private Block sapling;
    private MapColor mapColor;

    public BlockModLeaves(String name, float hardness, @Nonnull MapColor mapColorIn) {
        super();
        this.setMapColor(mapColorIn);
        this.setUnlocalizedName(name);
        this.setRegistryName(Reference.MODID, name);
        this.setHardness(hardness);
        this.setCreativeTab(DivineRPGTabs.BlocksTab);
        this.setTickRandomly(true);
        this.setDefaultState(blockState.getBaseState().withProperty(CHECK_DECAY, true).withProperty(DECAYABLE, true));

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    public BlockModLeaves(String name, float hardness, Block sapling, @Nonnull MapColor mapColorIn) {
        this(name, hardness, mapColorIn);
        this.sapling = sapling;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] { CHECK_DECAY, DECAYABLE });
    }

    @Override
    public int damageDropped(IBlockState state) {
        return 0;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return (this.sapling != null) ? Item.getItemFromBlock(this.sapling) : null;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;

        if (!state.getValue(DECAYABLE)) {
            i |= 4;
        }

        if (state.getValue(CHECK_DECAY)) {
            i |= 8;
        }
        return i;
    }

    @Deprecated
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(DECAYABLE, (meta & 4) == 0).withProperty(CHECK_DECAY,
                (meta & 8) > 0);
    }

    @Override
    public BlockPlanks.EnumType getWoodType(int meta) {
        return BlockPlanks.EnumType.OAK;
    }

    @Override
    public NonNullList<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos,
            int fortune) {
        return NonNullList.withSize(1, new ItemStack(this, 1, 0));
    }

    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state) {
        return new ItemStack(Item.getItemFromBlock(this));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        if (Minecraft.isFancyGraphicsEnabled()) {
            return BlockRenderLayer.CUTOUT_MIPPED;
        } else {
            return BlockRenderLayer.SOLID;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean isOpaqueCube(IBlockState state) {
        return !Minecraft.isFancyGraphicsEnabled();
    }

    @Override
    public boolean isFullCube(IBlockState state) {
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
            this.mapColor = Material.LEAVES.getMaterialMapColor();
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
        if(this.mapColor == null) {
            return super.getMapColor(state, worldIn, pos);
        }
        return this.mapColor;
    }
}