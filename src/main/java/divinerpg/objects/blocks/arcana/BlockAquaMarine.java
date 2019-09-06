package divinerpg.objects.blocks.arcana;

import divinerpg.registry.ModItems;
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
        return ModItems.aquamarineSeeds;
    }

    @Override
    public Item getCrop() {
        return ModItems.aquamarine;
    }
}