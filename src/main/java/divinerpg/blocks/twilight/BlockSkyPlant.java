package divinerpg.blocks.twilight;

import divinerpg.blocks.base.*;
import divinerpg.registries.*;
import net.minecraft.util.*;

public class BlockSkyPlant extends BlockModCrop {
    public BlockSkyPlant() {
        super("sky_plant", 0.5);
    }


    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    protected IItemProvider getBaseSeedId() {
        return ItemRegistry.skyPlantSeeds;
    }

}
