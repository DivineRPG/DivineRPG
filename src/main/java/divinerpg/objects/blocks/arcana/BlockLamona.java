package divinerpg.objects.blocks.arcana;

import divinerpg.objects.blocks.BlockModCrop;
import divinerpg.registry.ItemRegistry;
import net.minecraft.item.Item;

public class BlockLamona extends BlockModCrop {

    public BlockLamona(String name) {
        super(name);
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    public Item getSeed() {
        return ItemRegistry.lamonaSeeds;
    }

    @Override
    public Item getCrop() {
        return ItemRegistry.lamona;
    }
}