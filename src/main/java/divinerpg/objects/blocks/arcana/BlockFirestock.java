package divinerpg.objects.blocks.arcana;

import divinerpg.registry.ItemRegistry;
import net.minecraft.item.Item;

public class BlockFirestock extends BlockStackPlant {
    public BlockFirestock() {
        super("firestock_plant");
    }

    public Item getSeedDrop() {
        return ItemRegistry.firestockSeeds;
    }

    public Item getFlowerDrop() {
        return ItemRegistry.firestock;
    }
}