package divinerpg.objects.blocks.arcana;

import divinerpg.objects.blocks.BlockModCrop;
import divinerpg.registry.ItemRegistry;
import net.minecraft.item.Item;

public class BlockAquaMarine extends BlockModCrop {

    public BlockAquaMarine(String name) {
        super(name);
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    public Item getSeed() {
        return ItemRegistry.aquamarineSeeds;
    }

    @Override
    public Item getCrop() {
        return ItemRegistry.aquamarine;
    }
}