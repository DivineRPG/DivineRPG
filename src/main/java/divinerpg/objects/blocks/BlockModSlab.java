package divinerpg.objects.blocks;

import divinerpg.DivineRPG;
import divinerpg.objects.items.base.ItemModSlab;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Locale;
import java.util.Random;

public class BlockModSlab extends BlockSlab {
    private static final IProperty<ModSlabVariant> VARIANT = PropertyEnum.create("variant", ModSlabVariant.class);
    private final boolean isDouble;
    private final BlockModSlab singleSlab;

    public BlockModSlab(String name, Block block, float hardness, BlockModSlab singleSlab, boolean isDouble) {
        super(block.getDefaultState().getMaterial());
        this.setRegistryName(DivineRPG.MODID, name);
        this.setUnlocalizedName(name);
        this.isDouble = isDouble;

        IBlockState iblockstate = this.blockState.getBaseState();
        if (!this.isDouble())
        {
            iblockstate = iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
            this.singleSlab = this;
        }
        else {
            this.singleSlab = singleSlab;
        }

        this.setHardness(hardness);
        if(hardness < 0) {
            this.setResistance(6000000F);
        }

        this.setDefaultState(iblockstate.withProperty(VARIANT, ModSlabVariant.BASE));
        this.setCreativeTab(DivineRPGTabs.BLOCKS);
    }

    public BlockModSlab getSingle() {
        return this.singleSlab;
    }

    @Override
    public boolean isDouble() {
        return this.isDouble;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this.singleSlab);
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(Item.getItemFromBlock(this.singleSlab));
    }

    @Override
    public String getUnlocalizedName(int meta)
     {
          return super.getUnlocalizedName();
     }

    @Override
    public IProperty<?> getVariantProperty() {
        return VARIANT;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack)
    {
        return ModSlabVariant.BASE;
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(HALF).ordinal();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return this.isDouble() ? new BlockStateContainer(this, new IProperty[]{VARIANT}) : new BlockStateContainer(this, new IProperty[]{HALF, VARIANT});
    }

    public enum ModSlabVariant implements IStringSerializable {
        BASE;

        @Override
        public String getName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }
}