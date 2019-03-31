package naturix.divinerpg.objects.blocks;

import java.util.Random;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.enums.WoodVariant;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class BlockModSlab extends BlockSlab implements IHasModel {
    public static final PropertyEnum<WoodVariant> VARIANT = PropertyEnum.<WoodVariant>create("variant",
            WoodVariant.class);

    public final String NAME;
    private Block single;
    private WoodVariant woodType;

    public BlockModSlab(BlockMod plank, Block single, WoodVariant woodType) {
        super(Material.WOOD, woodType.getMapColor());
        setHardness(plank.getBlockModHardness());
        setResistance(5);

        NAME = plank.name.replace("_planks", "_") + (isDouble() ? "double_slab" : "slab");
        setUnlocalizedName(NAME);
        setRegistryName(NAME);

        this.single = single;
        this.woodType = woodType;
        if (this.isDouble()) {
            setDefaultState(this.blockState.getBaseState().withProperty(this.getVariantProperty(), woodType));
        } else {
            useNeighborBrightness = true;
            setDefaultState(this.blockState.getBaseState().withProperty(this.getVariantProperty(), woodType)
                    .withProperty(HALF, EnumBlockHalf.BOTTOM));
            setCreativeTab(DRPGCreativeTabs.BlocksTab);
        }

        ModBlocks.BLOCKS.add(this);
    }

    public String getUnlocalizedName(int meta) {
        return super.getUnlocalizedName();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return this.isDouble() ? new BlockStateContainer(this, this.getVariantProperty())
                : new BlockStateContainer(this, this.getVariantProperty(), HALF);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(getSingle());
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(Item.getItemFromBlock(getSingle()));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.isDouble() ? this.getDefaultState()
                : this.getDefaultState().withProperty(HALF, meta == 0 ? EnumBlockHalf.BOTTOM : EnumBlockHalf.TOP);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return this.isDouble() ? 0 : state.getValue(HALF) == EnumBlockHalf.BOTTOM ? 0 : 1;
    }

    @Override
    public abstract boolean isDouble();

    @Override
    public abstract IProperty<WoodVariant> getVariantProperty();

    @Override
    public Comparable<WoodVariant> getTypeForItem(ItemStack stack) {
        return woodType;
    }

    protected abstract Block getSingle();

    @Override
    public void registerModels() {
        DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
