package divinerpg.objects.blocks.arcana;

import divinerpg.registry.ModItems;
import divinerpg.registry.ModSeeds;
import net.minecraft.item.Item;

public class BlockFirestock extends BlockStackPlant {
    public BlockFirestock() {
        super("firestock_plant");
    }

    public Item getSeedDrop() {
        return ModSeeds.firestockSeeds;
    }

    public Item getFlowerDrop() {
        return ModItems.firestock;
    }
}