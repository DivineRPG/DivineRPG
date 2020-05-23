package divinerpg.objects.blocks.arcana;

import divinerpg.registry.ItemRegistry;
import net.minecraft.item.Item;

public class BlockPinfly extends BlockStackPlant {
    public BlockPinfly() {
        super("pinfly_plant");
    }

    public Item getSeedDrop() {
        return ItemRegistry.pinflySeeds;
    }

    public Item getFlowerDrop() {
        return ItemRegistry.pinfly;
    }
}