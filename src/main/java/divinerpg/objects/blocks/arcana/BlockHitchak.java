package divinerpg.objects.blocks.arcana;

import divinerpg.registry.ModItems;
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
        return ModItems.hitchakSeeds;
    }

    @Override
    public Item getCrop() {
        return ModItems.hitchak;
    }
}