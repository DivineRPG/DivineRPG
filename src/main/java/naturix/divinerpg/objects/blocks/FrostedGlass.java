package naturix.divinerpg.objects.blocks;

import naturix.divinerpg.DivineRPG;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;

/**
 * Created by LiteWolf101 on Jan
 * /28/2019
 */
public class FrostedGlass extends Block {
    protected String name;
    public FrostedGlass(String name) {
        super(Material.GLASS);
        setSoundType(SoundType.GLASS);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DivineRPG.BlocksTab);
        this.setHardness(1);
    }

    public void registerItemModel(Item itemBlock) {
        DivineRPG.proxy.registerItemRenderer(itemBlock, 0, name);
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
}
