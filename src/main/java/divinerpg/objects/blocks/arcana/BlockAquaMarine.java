package divinerpg.objects.blocks.arcana;

import divinerpg.registry.ModItems;
import divinerpg.registry.ModSeeds;
import net.minecraft.item.Item;

public class BlockAquaMarine extends BlockArcanaCrop {

    public BlockAquaMarine(String name) {
        super(name);
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    public Item getSeed() {
        return ModSeeds.aquamarineSeeds;
    }

    @Override
    public Item getCrop() {
        return ModItems.aquamarine;
    }
}