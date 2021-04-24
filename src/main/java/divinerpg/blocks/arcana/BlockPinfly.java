package divinerpg.blocks.arcana;

import divinerpg.blocks.base.*;
import divinerpg.registries.*;
import net.minecraft.util.*;

public class BlockPinfly extends BlockStackPlant {
    public BlockPinfly() {
        super("pinfly_plant");
    }

    @Override
    protected IItemProvider getBaseSeedId() {
        return ItemRegistry.pinflySeeds;
    }
}
