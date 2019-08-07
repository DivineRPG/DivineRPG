package naturix.divinerpg.objects.blocks.arcana;

import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSeeds;
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