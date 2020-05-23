package divinerpg.objects.blocks.arcana;

import divinerpg.registry.ItemRegistry;
import net.minecraft.item.Item;

public class BlockMarsine extends BlockArcanaCrop {

    public BlockMarsine(String name) {
        super(name);
    }

    @Override
    public int getMaxAge() {
        return 2;
    }

    @Override
    public Item getSeed() {
        return ItemRegistry.marsineSeeds;
    }

    @Override
    public Item getCrop() {
        return ItemRegistry.marsine;
    }
}