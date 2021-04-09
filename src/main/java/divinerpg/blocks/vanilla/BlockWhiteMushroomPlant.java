package divinerpg.blocks.vanilla;

import divinerpg.blocks.base.*;
import divinerpg.registries.*;
import net.minecraft.util.*;

public class BlockWhiteMushroomPlant extends BlockModCrop {
    public BlockWhiteMushroomPlant() {
        super("white_mushroom_plant", 0.3);
    }

    @Override
    public int getMaxAge() {
        return 1;
    }

    @Override
    protected IItemProvider getBaseSeedId() {
        return ItemRegistry.whiteMushroomSeeds;
    }
}