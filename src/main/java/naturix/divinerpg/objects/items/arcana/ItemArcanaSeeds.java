package naturix.divinerpg.objects.items.arcana;

import naturix.divinerpg.objects.items.base.ItemModSeeds;
import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;

public class ItemArcanaSeeds extends ItemModSeeds {

    public ItemArcanaSeeds(String name, Block crop) {
        super(name, crop, ModBlocks.arcanaGrass);
    }
}