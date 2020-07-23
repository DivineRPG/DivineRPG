package divinerpg.objects.blocks.vanilla;

import divinerpg.objects.blocks.BlockModCrop;
import divinerpg.registry.ItemRegistry;
import net.minecraft.item.Item;

public class BlockWhiteMushroomPlant extends BlockModCrop {
    public BlockWhiteMushroomPlant() {
        super("white_mushroom_plant", 0.3);
    }

    @Override
    public int getMaxAge() {
        return 1;
    }

    @Override
    protected Item getSeed() {
        return ItemRegistry.whiteMushroomSeeds;
    }

    @Override
    protected Item getCrop() {
        return ItemRegistry.whiteMushroom;
    }
}