package divinerpg.objects.blocks.arcana;

import divinerpg.registry.ModItems;
import net.minecraft.item.Item;

public class BlockFirestock extends BlockStackPlant {
    public BlockFirestock() {
        super("firestock_plant");
    }

    public Item getSeedDrop() {
        return ModItems.firestockSeeds;
    }

    public Item getFlowerDrop() {
        return ModItems.firestock;
    }
}