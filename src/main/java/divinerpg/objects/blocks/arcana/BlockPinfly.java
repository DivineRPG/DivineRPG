package divinerpg.objects.blocks.arcana;

import divinerpg.registry.ModItems;
import net.minecraft.item.Item;

public class BlockPinfly extends BlockStackPlant {
    public BlockPinfly() {
        super("pinfly_plant");
    }

    public Item getSeedDrop() {
        return ModItems.pinflySeeds;
    }

    public Item getFlowerDrop() {
        return ModItems.pinfly;
    }
}