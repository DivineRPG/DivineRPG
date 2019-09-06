package divinerpg.objects.blocks.arcana;

import divinerpg.registry.ModItems;
import net.minecraft.item.Item;

public class BlockLamona extends BlockArcanaCrop {

    public BlockLamona(String name) {
        super(name);
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    public Item getSeed() {
        return ModItems.lamonaSeeds;
    }

    @Override
    public Item getCrop() {
        return ModItems.lamona;
    }
}