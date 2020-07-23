package divinerpg.objects.blocks.arcana;

import divinerpg.objects.blocks.BlockModCrop;
import divinerpg.registry.ItemRegistry;
import net.minecraft.item.Item;

public class BlockHitchak extends BlockModCrop {

    public BlockHitchak(String name) {
        super(name);
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    public Item getSeed() {
        return ItemRegistry.hitchakSeeds;
    }

    @Override
    public Item getCrop() {
        return ItemRegistry.hitchak;
    }
}