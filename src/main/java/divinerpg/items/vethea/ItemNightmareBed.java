package divinerpg.items.vethea;

import divinerpg.DivineRPG;
import divinerpg.client.renders.item.NightmareBedTEISR;
import divinerpg.registries.BlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.item.*;

public class ItemNightmareBed extends BlockItem {
    public ItemNightmareBed() {
        super(BlockRegistry.nightmareBed, new Item.Properties().tab(DivineRPG.tabs.vethea).stacksTo(1).setISTER(() -> () -> new NightmareBedTEISR()));
        setRegistryName("nightmare_bed");
    }
    protected boolean placeBlock(BlockItemUseContext context, BlockState state) {
        return context.getLevel().setBlock(context.getClickedPos(), state, 26);
    }
}
