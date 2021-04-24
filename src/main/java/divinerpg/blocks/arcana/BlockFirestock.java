package divinerpg.blocks.arcana;

import divinerpg.blocks.base.*;
import divinerpg.registries.*;
import net.minecraft.util.*;

public class BlockFirestock extends BlockStackPlant {
    public BlockFirestock() {
        super("firestock_plant");
    }

    @Override
    protected IItemProvider getBaseSeedId() {
        return ItemRegistry.firestockSeeds;
    }
}
