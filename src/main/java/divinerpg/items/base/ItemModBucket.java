package divinerpg.items.base;

import divinerpg.*;
import net.minecraft.fluid.*;
import net.minecraft.item.*;

import java.util.function.*;

public class ItemModBucket extends BucketItem {

    public ItemModBucket(String name, Supplier<? extends Fluid> supplier) {
        super(supplier, new Properties().stacksTo(1).tab(DivineRPG.tabs.utilities));
    setRegistryName(name);
    }
}
