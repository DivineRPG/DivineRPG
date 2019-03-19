package naturix.divinerpg.objects.blocks;

import java.util.Random;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockModSlab extends BlockSlab implements IHasModel {
    public final String NAME;
    boolean isDouble = false;
    private Block single;

    public BlockModSlab(BlockMod base, Block single) {
        super(base.blockType.getMaterial(), base.blockType.getMaterial().getMaterialMapColor());
        setHardness(base.getBlockModHardness());
        setResistance(5);
        NAME = base.name.replace("_planks", "_") + ((single == null) ? "slab" : "slab_double");
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        this.single = single;
        if (single == null) {
            useNeighborBrightness = true;
        } else {
            isDouble = true;
        }
        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    public String getUnlocalizedName(int meta) {
        return super.getUnlocalizedName();
    }

    public boolean isDouble() {
        return this.isDouble;
    }

    public IProperty<?> getVariantProperty() {
        return null;
    }

    public Comparable<?> getTypeForItem(ItemStack stack) {
        return null;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(this.isDouble ? single : this);
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(Item.getItemFromBlock(this.isDouble ? single : this));
    }

    @Override
    public void registerModels() {
        DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
