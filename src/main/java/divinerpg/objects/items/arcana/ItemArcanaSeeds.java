package divinerpg.objects.items.arcana;

import divinerpg.objects.items.base.ItemModSeeds;
import divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;

public class ItemArcanaSeeds extends ItemModSeeds {

    public ItemArcanaSeeds(String name, Block crop) {
        super(name, crop, ModBlocks.arcanaGrass);
    }
}