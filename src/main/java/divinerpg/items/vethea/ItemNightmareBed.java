package divinerpg.items.vethea;

import divinerpg.DivineRPG;
import divinerpg.client.renders.item.NightmareBedTEISR;
import divinerpg.registries.BlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.item.*;

public class ItemNightmareBed extends BlockItem {
    public ItemNightmareBed() {
        super(BlockRegistry.nightmareBed, new Item.Properties().group(DivineRPG.tabs.vethea).maxStackSize(1).setISTER(() -> () -> new NightmareBedTEISR()));
        setRegistryName("nightmare_bed");
    }
    protected boolean placeBlock(BlockItemUseContext context, BlockState state) {
        return context.getWorld().setBlockState(context.getPos(), state, 26);
    }
}
