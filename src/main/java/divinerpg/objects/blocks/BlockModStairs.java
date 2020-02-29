package divinerpg.objects.blocks;

import java.util.function.Supplier;

import divinerpg.api.java.divinerpg.api.Reference;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.item.ItemBlock;

public class BlockModStairs extends BlockStairs  {

    private Supplier<Block> baseSupplier;
    
    public BlockModStairs(String name, Supplier<Block> base) {
        super(base.get().getDefaultState());
        this.useNeighborBrightness = true;
        setUnlocalizedName(name);
        setRegistryName(Reference.MODID, name);
        this.setCreativeTab(DivineRPGTabs.BlocksTab);
    }
}