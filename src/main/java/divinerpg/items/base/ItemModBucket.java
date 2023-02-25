package divinerpg.items.base;

import divinerpg.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.material.*;

import java.util.function.*;

public class ItemModBucket extends BucketItem {

    public ItemModBucket(Supplier<? extends Fluid> supplier) {
        super(supplier, new Properties().stacksTo(1).tab(DivineRPG.tabs.utilities));
    }
}
