package divinerpg.objects.blocks.arcana;

import divinerpg.registry.ModItems;
import divinerpg.registry.ModSeeds;
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
        return ModSeeds.marsineSeeds;
    }

    @Override
    public Item getCrop() {
        return ModItems.marsine;
    }
}