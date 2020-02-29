package divinerpg.objects.blocks;

import java.util.function.Supplier;

import divinerpg.api.java.divinerpg.api.Reference;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;

public class BlockModStairs extends BlockStairs  {
    
    public BlockModStairs(String name, Block base) {
        super(base.getDefaultState());
        setUnlocalizedName(name);
        setRegistryName(Reference.MODID, name);
        this.setCreativeTab(DivineRPGTabs.BlocksTab);
        this.useNeighborBrightness = true;
    }
}