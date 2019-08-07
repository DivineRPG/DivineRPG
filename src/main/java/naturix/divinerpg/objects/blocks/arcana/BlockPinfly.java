package naturix.divinerpg.objects.blocks.arcana;

import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSeeds;
import net.minecraft.item.Item;

public class BlockPinfly extends BlockStackPlant {
    public BlockPinfly() {
        super("pinfly_plant");
    }

    public Item getSeedDrop() {
        return ModSeeds.pinflySeeds;
    }

    public Item getFlowerDrop() {
        return ModItems.pinfly;
    }
}