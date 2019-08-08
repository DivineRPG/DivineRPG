package naturix.divinerpg.objects.blocks.arcana;

import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSeeds;
import net.minecraft.item.Item;

public class BlockHitchak extends BlockArcanaCrop {

    public BlockHitchak(String name) {
        super(name);
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    public Item getSeed() {
        return ModSeeds.hitchakSeeds;
    }

    @Override
    public Item getCrop() {
        return ModItems.hitchak;
    }
}