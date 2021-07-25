package divinerpg.items.vethea;

import divinerpg.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.item.*;

public class ItemNightmareBed extends BlockItem {
    public ItemNightmareBed() {
        super(BlockRegistry.nightmareBed, new Item.Properties().tab(DivineRPG.tabs.vethea).stacksTo(1)
        );
        setRegistryName("nightmare_bed");
    }
    protected boolean placeBlock(BlockItemUseContext context, BlockState state) {
        return context.getLevel().setBlock(context.getClickedPos(), state, 26);
    }
}
