package divinerpg.objects.items.arcana;

import divinerpg.objects.items.base.ItemModSeeds;
import divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;

import java.util.function.Supplier;

public class ItemArcanaSeeds extends ItemModSeeds {

    public ItemArcanaSeeds(String name, Supplier<Block> cropSupplier) {
        super(name, cropSupplier, () -> ModBlocks.arcaniteGrass);
    }
}