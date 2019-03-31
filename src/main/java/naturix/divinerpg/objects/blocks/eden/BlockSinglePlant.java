package naturix.divinerpg.objects.blocks.eden;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.IPlantable;

public class BlockSinglePlant extends BlockBush implements IHasModel, IPlantable {

    public BlockSinglePlant(String name) {
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(DRPGCreativeTabs.BlocksTab);
        setSoundType(SoundType.PLANT);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    @SuppressWarnings("deprecation")
    protected boolean canSustainBush(IBlockState state)
    {
        return state.getBlock().getMaterial(state) == Material.GRASS;
    }

    @Override
    public void registerModels() {
        DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}
