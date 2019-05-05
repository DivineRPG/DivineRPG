package naturix.divinerpg.objects.blocks.vanilla;

import naturix.divinerpg.objects.blocks.BlockModCrop;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSeeds;
import net.minecraft.item.Item;

public class BlockWhiteMushroomPlant extends BlockModCrop {
    public BlockWhiteMushroomPlant() {
        super("white_mushroom_plant");
    }

    @Override
    public int getMaxAge() {
        return 1;
    }

    @Override
    protected Item getSeed() {
        return ModSeeds.whiteMushroomSeeds;
    }

    @Override
    protected Item getCrop() {
        return ModItems.whiteMushroom;
    }
}